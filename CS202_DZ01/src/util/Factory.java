package util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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
}