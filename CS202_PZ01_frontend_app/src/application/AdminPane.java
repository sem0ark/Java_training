package application;

import data_classes.User;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import network.Connector;
import util.TableBuilder;

public class AdminPane extends EntryPane {

	public AdminPane(Connector conn) {
		super(conn);
		addAdminTabs();
		System.out.println("Init admin");
	}
	
	private void addAdminTabs() {
		Tab tab;
		
		tab = new Tab("User", makeUsersPane());
		tab.setClosable(false);
		super.getTabs().add(tab);
	}
	
	private BorderPane makeUsersPane() {
		BorderPane b = new BorderPane();
		
		b.setCenter((new TableBuilder<User>())
			.<Integer>addColumn("ID", "id")
			.<String>addColumn("Username", "username")
			.<String>addColumn("E-mail", "email")
			.addAll(conn.getUsers()).build()
		);
		return b;
	}
}
