package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.Factory;

/**
 * 
 * @author Arkadii Semenov 5833 SI FIT
 * @summary CS202 DZ05 Task 1
 * Napraviti u JavaFx program za kreiranje MenuBar-a sa MenuItems.
 *
 */
public class Main extends Application {
  
  @Override
  public void start(Stage primaryStage) {   
    VBox vBox = new VBox(10);
    vBox.getChildren().add(Factory.makeMenuBar(new Menu[] {
		Factory.makeMenu("File", new String[] { "New", "Open File", "Exit"}),
		Factory.makeMenu("Edit", new String[] { "Copy", "Paste", "Delete"}),
		Factory.makeMenu("Help", new String[] { "Open Documentation", "Quick Help"}),
	}));
    Scene scene = new Scene(vBox, 300, 250);  
    primaryStage.setTitle("CS202 DZ05 Arkadii Semenov 5833 SI FIT");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
} 