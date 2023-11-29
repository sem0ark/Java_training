package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import util.Factory;
import util.SimplePieChart;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
	        BorderPane root = new BorderPane();
	        String[] names = {"Hello   ", "GoodBye   ", "Grapes   "};
	        double[] values = {70, 30, 10};
	        
	        SimplePieChart chart = Factory.makePieChart(names, values, "Info");
	        root.setCenter(chart);

	        GridPane grid = new GridPane();
	        
	        int c = 0;
	        for(String v : names) {
	        	final int row = c;
	        	Factory.addLabeledTextInput(grid, v, row, String.valueOf(values[c]), e -> {
	        		chart.setValue(row, Double.valueOf(((TextField) e.getSource()).getText()));
	        	});
	        	
	        	c++;
	        }
	        
	        root.setBottom(grid);	        
	        stage.setScene(new Scene(root, 400, 400));
	        stage.setTitle("Info");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
