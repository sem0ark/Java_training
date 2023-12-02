package util;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;

import javafx.scene.Node;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import javafx.util.Duration;
import javafx.util.Pair;

/**
 * 
 * @author Arkadii
 * @description Utility class implementing standard Factory Methods for making different UI elements.
 * 				It provides some useful interfaces and functions for quickly building the UI.
 *
 */
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
	
	public static <T> ChoiceBox<T> choice(T[] values) {
		return new ChoiceBox<T>(FXCollections.observableArrayList(values));
	}
	
	public static <T> ChoiceBox<T> choice(T[] values, Handler<T> handler) {
		ChoiceBox<T> cb = Factory.<T>choice(values);

		cb.getSelectionModel().selectedIndexProperty().addListener((ov, o, n) -> {
			handler.handle(values[
			    Math.min(Math.max(n.intValue(), 0), values.length-1)
		    ]);
		});
		cb.getSelectionModel().selectFirst();
		return cb;
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
	
	public static TextField addNonEditableLabeledTextInput(GridPane grid, String label, int row, int width, String text) {
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
	
	public static GridPane makeGrid2DArr(Node[][] nodes) {
		GridPane grid = new GridPane();
		
		for(int i=0; i<nodes.length; i++)
			for(int j=0; j<nodes[i].length; j++)
				if(nodes[i][j] != null)
					grid.add(nodes[i][j], j, i);
		return grid;
	}
	
	public static GridPane makeGrid2DArr(Node[][] nodes, double w, double h) {
		GridPane grid = new GridPane();
		grid.setPrefWidth(w);
		grid.setPrefHeight(h);
		
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
	
	public static TabPane makeTabPane(String[] names, Node[] contents, boolean closeable) {
		assert names.length == contents.length : "Assumed to have the same length";
		
		TabPane tabPane = new TabPane();
		
		for(int i=0; i<names.length; i++) {
			Tab tab = new Tab(names[i], contents[i]);
			tab.setClosable(closeable);
			tabPane.getTabs().add(tab);
		}
		
		return tabPane;
	}

	/////////////// MENUS
	public static MenuBar makeMenuBar(Menu[] menus) {
		MenuBar bar = new MenuBar();
		for(Menu i : menus) bar.getMenus().add(i);
		return bar;
	}
	
	public static Menu makeMenu(String menuName, String[] children) {
		Menu menu = new Menu(menuName);
		for(String i : children) menu.getItems().add(new MenuItem(i));
		return menu;
	}
	
	public static Menu makeMenu(String menuName, String[] children, EventHandler<ActionEvent>[] handlers) {
		assert children.length == handlers.length : "children and handlers arrays should be the same length";
		Menu menu = new Menu(menuName);
		
		for(int i=0; i<children.length; i++) {
			MenuItem item = new MenuItem(children[i]);
			if(handlers[i] != null) item.setOnAction(handlers[i]);
			menu.getItems().add(item);
		}
		
		return menu;
	}
	
	public static Menu makeMenu(String menuName, String[] children, EventHandler<ActionEvent>[] handlers, KeyCombination[] accelerators) {
		assert children.length == handlers.length && handlers.length == accelerators.length: "arrays should be the same length";
		Menu menu = new Menu(menuName);
		
		for(int i=0; i < children.length; i++) {
			MenuItem item = new MenuItem(children[i]);
			if(handlers[i] != null) item.setOnAction(handlers[i]);
			if(accelerators[i] != null) item.setAccelerator(accelerators[i]);
			menu.getItems().add(item);
		}
		
		return menu;
	}
	
	
	/////////////// Buttons
	
	public static RadioButton makeRadio(String label) {
		return new RadioButton(label);
	}
	
	public static <T> RadioButton makeRadio(String label, T value) {
		RadioButton r = new RadioButton(label);
		r.setUserData(value);
		return r;
	}
	
	public static <T> RadioButton[] makeRadios(String[] labels, T[] values) {
		assert labels.length == values.length : "Assumed to have the same length";
		
		
		RadioButton[] res = new RadioButton[labels.length]; 
		for(int i=0; i<labels.length; i++) {
			res[i] = Factory.makeRadio(labels[i], values[i]);
		}
		return res;
	}
	
	public static void setToggleGroup(ToggleGroup tg, RadioButton[] rbs) {
		for(RadioButton i : rbs) i.setToggleGroup(tg);
	}
	
	public static void addRadioButtons2Grid(GridPane grid, int startRow, RadioButton[] rbs) {
		for(int i=0; i<rbs.length; i++) {
			grid.add(rbs[i], 0, startRow + i);
		}
	}
	
	
	/////////////// HANDLERS
	public static EventHandler<ActionEvent> Exit = e -> System.exit(0);
	
	public interface Handler<T> {
		public void handle(T value);
	}
	
	public interface OuterHandler<T, P> {
		public void handle(T value, P parent);
	}
	
	/////////////// DIALOGS
	public interface DialogValueHandler<T> {
		public void handle(T value);
	}
	
	public static void runTextDialog(String title, String header, String content, Consumer<String> handler) {
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(content);

		Optional<String> result = dialog.showAndWait();
		result.ifPresent(handler);
	}
	
	public static void runLoginDialog(String title, String header, Consumer<Pair<String, String>> handler) {
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle(title);
		dialog.setHeaderText(header);

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField username = new TextField(); username.setPromptText("Username");
		PasswordField password = new PasswordField(); password.setPromptText("Password");

		grid.add(new Label("Username:"), 0, 0); grid.add(username, 1, 0);
		grid.add(new Label("Password:"), 0, 1); grid.add(password, 1, 1);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
		    loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);
		Platform.runLater(() -> username.requestFocus()); // Request focus by default.
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) return new Pair<>(username.getText(), password.getText());
		    return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();
		result.ifPresent(handler);
	}
	
	public static <T> void runChoiceDialog(String title, String header, String content, T[] values, Consumer<T> handler) {
		ChoiceDialog<T> dialog = new ChoiceDialog<>(values[0], Arrays.asList(values));
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(content);

		Optional<T> result = dialog.showAndWait();
		result.ifPresent(handler);
	}

	public static void runInfoDialog(String title, String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.showAndWait();
	}
}



