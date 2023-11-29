package application;
	
import util.Factory;
import util.GridForm;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,200);
			
			final Label result = new Label();
			
			final GridForm tri, sq, rct;
			tri = new GridForm();
			
			tri.setHgap(10.0);
			tri.setVgap(10.0);
			
			tri.setRequired(true);
			tri.addForm(
				new String[] {"Base: ", "Height: "},
				"Compute Area",
				e -> {
					try {
						result.setText("Result: " + computeTriangle(tri.getValues()));
					} catch(Exception | AssertionError err) {
						System.out.println("Failed to compute values");
					}
				}
			);
			
			sq = new GridForm();
			sq.setRequired(true);

			sq.setHgap(10.0);
			sq.setVgap(10.0);
			
			sq.addForm(
				new String[] {"Base: "},
				"Compute Area",
				e -> {
					try {
						result.setText("Result: " + computeSquare(sq.getValues()));
					} catch(Exception | AssertionError err) {
						System.out.println("Failed to compute values");
					}
				}
			);
			
			rct = new GridForm();
			rct.setRequired(true);
			
			rct.setHgap(10.0);
			rct.setVgap(10.0);
			
			rct.addForm(
				new String[] {"Base: ", "Height: "},
				"Compute Area",
				e -> {
					try {
						result.setText("Result: " + computeRectangle(rct.getValues()));
					} catch(Exception | AssertionError err) {
						System.out.println("Failed to compute values");
					}
				}
			);
			
			root.setCenter(Factory.makeTabPane(
				new String[]{"Triangle", "Square", "Rectangle"},
				new GridPane[] {
					tri, sq, rct
				}
			));
			
			root.setBottom(result);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Arkadii Semenov 5833 SI FIT: Area calculator");
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static double computeSquare(String[] texts) {
		assert texts.length == 1 : "Can compute area from one side";
		double a = Double.valueOf(texts[0]);
		return a*a;
	}
	
	public static double computeTriangle(String[] texts) {
		assert texts.length == 2: "Can compute area from base and height";
		double a = Double.valueOf(texts[0]);
		double h = Double.valueOf(texts[1]);
		return a * h / 2.0;
	}
	
	public static double computeRectangle(String[] texts) {
		assert texts.length == 2 : "Can compute area from base and height";
		double a = Double.valueOf(texts[0]);
		double b = Double.valueOf(texts[1]);
		return a*b;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
