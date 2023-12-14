package server;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Main extends Application {

     @Override // Redefining the start() method of the Application class  
     public void start(Stage primaryStage) {
         TextArea ta = new TextArea();

         new Thread(() -> {
             try {
                 // Create server socket
                 ServerSocket serverSocket = new ServerSocket(8000);
                 Platform.runLater(() -> ta.appendText("Server started at " + new Date() + '\n'));

                 // Waiting for a connection request  
                 Socket socket = serverSocket.accept();

                 // Create input and output data stream 
                 DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                 DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                 while (true) {
                     double radius = inputFromClient.readDouble(); // Get the radius from the client
                     double area = radius * radius * Math.PI;
                     outputToClient.writeDouble(area); // Send surface back to client

                     Platform.runLater(() -> {
                         ta.appendText("Radius received from client: " + radius + '\n');
                         ta.appendText("Area is: " + area + '\n');
                     });
                 }
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
         }).start();

         // Creating a scene and putting it on stage  
         Scene scene = new Scene(new ScrollPane(ta), 450, 200);
         primaryStage.setTitle("Server");  // Enter stage name 
         primaryStage.setScene(scene);  // Place the scene on the stage 
         primaryStage.show();  // Stage display 
   }
}
