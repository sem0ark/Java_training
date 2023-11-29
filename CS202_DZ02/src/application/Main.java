package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class Main extends Application {
 
    @Override
    public void start(final Stage stage) {
        stage.setTitle("CS202 DZ02 Arkadii Semenov 5833");
 
        final FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
 
        final Button openButton = new Button("Select a file to open.");
 
        openButton.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) openFile(file);
        });
 
        final GridPane inputGridPane = new GridPane();
        inputGridPane.add(openButton, 0, 0);
 
        final Pane rootGroup = new VBox(30);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(30, 150, 30, 150));
 
        stage.setScene(new Scene(rootGroup));
        stage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    private static void configureFileChooser(final FileChooser fileChooser) {      
        fileChooser.setTitle("View TXT File");
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        );
        
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("TXT", "*.txt")
        );
    }
    
    private void openFile(File file) {
    	try {
    		Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				System.out.println(data);
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println("Failed reading file");
		}
    }
}