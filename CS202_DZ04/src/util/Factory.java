package util;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Factory {

	///////////// FACTORY
	
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
	
	///////////// GRID FACTORY
	
	public static TextField addLabeledTextInput(GridPane grid, String label, int row, int width) {
		TextField tf = new TextField();
		tf.setMinWidth(width);
		tf.setMaxWidth(width);
		grid.add(Factory.label(label), 0, row);
		grid.add(tf, 1, row);
		return tf;
	}
	
	public static TextField addLabeledTextInput(GridPane grid, String label, int row) {
		TextField tf = new TextField();
		grid.add(Factory.label(label), 0, row);
		grid.add(tf, 1, row);
		return tf;
	}
	
	public static TextField addLabeledTextInput(GridPane grid, String label, int row, EventHandler<ActionEvent> e) {
		TextField tf = new TextField();
		tf.setOnAction(e);
		
		grid.add(Factory.label(label), 0, row);
		grid.add(tf, 1, row);
		
		return tf;
	}
	
	public static TextField addLabeledTextInput(GridPane grid, String label, int row, String defaultValue, EventHandler<ActionEvent> e) {
		TextField tf = new TextField(defaultValue);
		tf.setOnAction(e);
		
		grid.add(Factory.label(label), 0, row);
		grid.add(tf, 1, row);
		
		return tf;
	}
	
	public static TextField addLabeledTextInput(GridPane grid, String label, int row, int width, String text) {
		TextField tf = new TextField(text);
		tf.setEditable(false);
		tf.setStyle("-fx-background-color: #cccccc; -fx-text-fill: #eeeeee;");
		tf.setMinWidth(width);
		tf.setMaxWidth(width);
		grid.add(Factory.label(label), 0, row);
		grid.add(tf, 1, row);
		
		return tf;
	}
	
	public static Button[][] makeButtonGrid(String lbl, EventHandler<ActionEvent> handler, int w, int h, int padding) {
		Button[][] res = new Button[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				 res[i][j] = new Button(lbl);
				 res[i][j].setOnAction(handler);
				 res[i][j].setPadding(new Insets(padding));
				 res[i][j].setFont(new Font(20));
			}
		}
		
		return res;
	}
	
	public static SwitchButton[][] makeSwitchButtonGrid(String[] lbls, EventHandler<ActionEvent> handler, int w, int h) {
		SwitchButton[][] res = new SwitchButton[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				 res[i][j] = new SwitchButton(lbls, handler);
			}
		}
		
		return res;
	}
	
	public static GridPane makeGrid2DArr(Node[][] nodes) {
		GridPane grid = new GridPane();
		
		for(int i=0; i<nodes.length; i++)
			for(int j=0; j<nodes[i].length; j++)
				if(nodes[i][j] != null)
					grid.add(nodes[i][j], j, i);
		return grid;
	}
	
	public static GridPane makeGrid2DArr(Node[][] nodes, double w, double h) {
		GridPane grid = new GridPane(w, h);
		
		for(int i=0; i<nodes.length; i++)
			for(int j=0; j<nodes[i].length; j++)
				if(nodes[i][j] != null)
					grid.add(nodes[i][j], j, i);
		return grid;
	}
	
	public static void updateGrid2DArr(GridPane grid, Node[][] nodes) {
		for(int i=0; i<nodes.length; i++)
			for(int j=0; j<nodes[i].length; j++)
				if(nodes[i][j] != null)
					grid.add(nodes[i][j], j, i);
	}
	
	public static void updateGrid2DArr(GridPane grid, Node[][] nodes, int off_row, int off_col) {
		for(int i=0; i<nodes.length; i++)
			for(int j=0; j<nodes[i].length; j++)
				if(nodes[i][j] != null)
					grid.add(nodes[i][j], j+off_col, i+off_row);
	}
	
	///////////// ANIMATION
	
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
	
	public static Timeline makeRepeater(Duration d, EventHandler<ActionEvent> e) {
		Timeline animation = new Timeline(new KeyFrame(d, e));
		animation.setCycleCount(Timeline.INDEFINITE);
		return animation;
	}

	///////////// CHARTS
	
	public static SimplePieChart makePieChart(String[] names, double[] values, String title) {
        return new SimplePieChart(names, values, title);
	}
	
	public static Series<Double, Double> makeDoubleChartSeries(double[] coords, double[] values, String title) {
		assert coords.length == values.length : "Coordinates should have the same length";
		
		Series<Double, Double> series = new Series<>();
		series.setName(title);
		
		for(int i=0; i<coords.length; i++)
			series.getData().add(new Data<Double, Double>(coords[i], values[i]));
		
		return series;
	}


	///////////// PANES
	
	public static TabPane makeTabPane(String[] names, Node[] contents) {
		assert names.length == contents.length : "Assumed to have the same length";
		
		TabPane tabPane = new TabPane();
		
		for(int i=0; i<names.length; i++) {
			Tab tab = new Tab(names[i], contents[i]);
			tab.setClosable(false);
			tabPane.getTabs().add(tab);
		}
		
		return tabPane;
	}
}
