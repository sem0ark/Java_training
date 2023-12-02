package application;

import data_classes.User;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import network.Connector;
import util.Factory;
import util.TableBuilder;
//import util.Factory;

public class EntryPane extends TabPane {
	Connector conn;
	
	public EntryPane(Connector conn) {
		super();
		this.conn = conn;
		addEntryTabs();
	}
	
	public void addEntryTabs() {
		Tab tab = new Tab("Performances", makePerformancesPane());
		tab.setClosable(false);
		this.getTabs().add(tab);
	}
	
	private BorderPane makePerformancesPane() {
		BorderPane b = new BorderPane();
		
		b.setCenter(
			(new TableBuilder<User>())
			.<String>addColumn("Username", "username")
			.<String>addColumn("E-mail", "email")
			.addAll(new User[] {
				new User("a", "b"),
				new User("b", "c"),
				new User("c", "d"),
			}).build()
		);
		return b;
	}
}
