package application;
	
import network.Connector;
import util.Factory;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
	Connector conn;
	BorderPane root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.conn = new Connector();
			
			root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			decideOnEnter();
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// sample login action
	private void decideOnEnter() {
		Factory.runLoginDialog("Login to the app", "", (t -> {
			if(t.getKey() == "admin" && t.getValue() == "admin") root.setCenter(new AdminPane(conn));
			else if(t.getKey() == "user" && t.getValue() == "user") root.setCenter(new UserPane(conn));
		}));
		
		if(this.root.getCenter() == null) root.setCenter(new EntryPane(conn));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}