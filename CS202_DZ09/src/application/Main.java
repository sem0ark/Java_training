package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import util.Factory;

/**
 * 
 * @author Arkadii Semenov 5833 SI FIT CS202_DZ09 
 * @task Create a JavaFX application that displays a blue square,
 * 		 scalable to the height and width of the scene.
 * 		 Using threads make the square change color (random color) every 5 seconds
 * 		 and simultaneously become invisible and visible again every 10 seconds.
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Group root = new Group(); 
	        Scene scene = new Scene(root, 500, 500, Color.BLACK); 
	        
	        Rectangle r = new Rectangle(50, 50, 0, 0); 
	        r.setFill(Color.BLUE); 
	        root.getChildren().add(r); 

	        r.widthProperty().bind(stage.widthProperty().multiply(0.5));
	        r.heightProperty().bind(stage.widthProperty().multiply(0.5));
	        
	        Thread t_color = new Thread(() -> {
	        	try {
	        		while (true) {
	        			r.setFill(Factory.visible ? Factory.getRandomColor() : Color.BLACK);
	        			Thread.sleep(5000);
		        	}					
				} catch (InterruptedException e) {
					e.printStackTrace();	
				}
	        });

	        Thread t_visible = new Thread(() -> {
	        	try {
	        		while (true) {
	        			Factory.visible = !Factory.visible;
	        			Thread.sleep(10000);
		        	}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        });

	        t_color.start();
	        t_visible.start();

	        stage.setTitle("CS202_DZ09-3 Arkadii Semenov 5833 SI FIT"); 
	        stage.setScene(scene); 
	        stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
