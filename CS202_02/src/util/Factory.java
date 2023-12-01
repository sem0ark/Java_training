package util;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Factory {
	public static Label label(String name) {
		return new Label(name);
	}
	
	public static Button button(String content) {
		return new Button(content);
	}
	
	public static Button button(String content, EventHandler<ActionEvent> e) {
		Button btn = new Button(content);
		btn.setOnAction(e);
		return btn;
	}
	
	public static void addLabeledTextInput(GridPane grid, String label, int row, int width) {
		TextField tf = new TextField();
		tf.setMinWidth(width);
		tf.setMaxWidth(width);
		grid.add(Factory.label(label), 0, row);
		grid.add(tf, 1, row);
	}
	
	public static void addLabeledTextInput(GridPane grid, String label, int row, int width, String text) {
		TextField tf = new TextField(text);
		tf.setEditable(false);
		tf.setStyle("-fx-background-color: #cccccc; -fx-text-fill: #eeeeee;");
		tf.setMinWidth(width);
		tf.setMaxWidth(width);
		grid.add(Factory.label(label), 0, row);
		grid.add(tf, 1, row);
	}
	
	public static void addFadeTransitionIndefinite(Duration d, double from, double to, Duration offset, boolean rev, Node... ns) {
		for(int i=0; i<ns.length; i++) {
			FadeTransition ft = new FadeTransition(d, ns[i]);
			ft.setFromValue(from);
			ft.setToValue(to);
			ft.setAutoReverse(rev);
			ft.setCycleCount(Timeline.INDEFINITE);
			Factory.playWithDelay(offset.multiply(i), ft);
		}
	}
	
	public static void playWithDelay(Duration d, Animation a) {
		SequentialTransition sq = new SequentialTransition(
	         new PauseTransition(d),
	         a
	     );
		
		sq.play();
	}
}