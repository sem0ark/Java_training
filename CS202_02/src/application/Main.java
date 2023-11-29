package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Factory;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
//			Circle c1 = new Circle(50, 50,  25, Color.BLUE);
//			Circle c2 = new Circle(100, 100, 25, Color.BLUE);
//			Circle c3 = new Circle(150, 150, 25, Color.BLUE);
//			Circle c4 = new Circle(200, 200, 25, Color.BLUE);
//			Circle c5 = new Circle(250, 250, 25, Color.BLUE);
//			Circle c6 = new Circle(300, 300, 25, Color.BLUE);
//			Circle c7 = new Circle(350, 350, 25, Color.BLUE);
//
//			root.getChildren().addAll(c1, c2, c3, c4, c5, c6, c7);
//			
//			int v = 20;
//			Factory.addFadeTransitionIndefinite(Duration.millis(v * 7), 1.0, 0.0, Duration.millis(v), true, c1, c2, c3, c4, c5, c6, c7);
			
			
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
