package com;   

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import util.Factory;

public class Main extends Application {
  
    @Override  
    public void start(Stage stage) throws Exception {    
    	int row = 0;
    	
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	
    	Factory.addLabeledTextInput(grid, "ID: ", row++, 150, "912381092");
    	Factory.addLabeledTextInput(grid, "First Name: ", row++, 500);
    	Factory.addLabeledTextInput(grid, "Middle Name: ", row++, 150);
    	Factory.addLabeledTextInput(grid, "Last Name: ", row++, 500);
    	Factory.addLabeledTextInput(grid, "Email: ", row++, 600);
    	Factory.addLabeledTextInput(grid, "Phone: ", row++, 150);
    	
    	HBox buttons = new HBox(
				Factory.button("New..."),
				Factory.button("Update"),
				Factory.button("Delete"),
				Factory.button("First"),
				Factory.button("Previous"),
				Factory.button("Next"),
				Factory.button("Last")
		);
    	
    	buttons.setSpacing(5);
    	buttons.setMinWidth(500);
		grid.add(buttons, 1, row++);
		
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        TitledPane title = new TitledPane("Person Details", grid);
        title.setCollapsible(false);
        
        HBox box = new HBox();
        box.getChildren().add(title);
        
        box.setPadding(new Insets(0, 30, 40, 30));
        
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }  
    
    public static void main (String[] args)  
    {  
        launch(args);  
    }  
  
} 