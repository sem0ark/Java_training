package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Factory;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Main extends Application {

	private class TreeCanvas extends Canvas {

	    GraphicsContext gc2d = getGraphicsContext2D();

	    int w, h;
	    
	    public TreeCanvas(int w, int h, int len, int angle) {
	        super();
	        this.w = w;
	        this.h = h;
	        
	        setWidth(w);
	        setHeight(h);
	        draw(len, angle);
	    }

	    public void draw(double len, double angle) {
	    	gc2d.clearRect(0, 0, this.getWidth(), this.getHeight());
	    	draw(this.w/2 + 30, this.h-20, len, angle);
	    }
	    
	    public void draw(double x, double y, double len, double angle) {
	    	gc2d.setLineWidth(1);

	        if (len > 3) {
	            double x1 = x + len * Math.cos(Math.toRadians(angle));
	            double y1 = y - len * Math.sin(Math.toRadians(angle));

	            gc2d.strokeLine(x, y, x1, y1);

	            draw(x1, y1, len * 0.6, angle * 0.9 + 40.0);
	            draw(x1, y1, len * 0.7, angle * 0.9 - 25.0);
	        }
	    }
	}
	
	final int w = 500, h = 400, len = 2;
	int angle = 80;
	
    TreeCanvas tree = new TreeCanvas(w, h, len, angle);

    
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, w, h);

        Factory.makeRepeater(
        	Duration.millis(16),
        	new EventHandler<ActionEvent>() {
        		int a = 0;
        		int step = (1<<5) - 1;
        		
        		double da = Math.random();
        		double da_prev = Math.random(); 
				@Override
				public void handle(ActionEvent e) {
					this.a++;
					tree.draw(Math.min(100, len + a * 0.1), angle + a * 0.01);
					
					if((this.a & this.step) == 0) {
						da_prev = da;
						da = Math.random();
					}
				}
			}
        ).play();
        
        root.getChildren().add(tree);

        stage.setTitle("Recursive drawing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
