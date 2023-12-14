package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


import java.io.*;
import java.net.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Main extends Application {
    // IO streams
    DataOutputStream toServer;
    DataInputStream fromServer;

    @Override
    public void start(Stage primaryStage) {
        TextField tf = new TextField();
        TextArea ta = new TextArea();
        
        tf.setOnAction(e -> {
            try {
                // get data from the text field
                double radius = Double.parseDouble(tf.getText().trim());

                // send the information to the server  
                toServer.writeDouble(radius); toServer.flush();  
                double area = fromServer.readDouble();
                // receive the information from the server

                ta.appendText("Radius is " + radius + "\n");
                ta.appendText("Area received from the server is " + area + '\n');
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });

        try { // make connection
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ta.appendText(ex.toString() + '\n');
        }

        // setting pup the UI
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter a radius: "));


        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);
          
        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Client"); // Unos naziva pozornice  
        primaryStage.setScene(scene); // Postavljanje scene na pozornicu  
        primaryStage.show(); // Prikaz pozornice  
    }
} 