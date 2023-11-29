package cs202_01;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label lbl = new Label("Test Label");
        Button btn = new Button("Click!");
        
        grid.add(lbl, 0, 0);
        grid.add(btn, 1, 0);
        
        btn.setOnAction(e -> {
        	lbl.setText("Info: ");
        });
    	
        stage.setTitle("Test 1");
        stage.setScene(new Scene(grid, 300, 250));
        stage.show();
    }
}