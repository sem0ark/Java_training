package application;

import data_classes.User;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import network.Connector;
import util.TableBuilder;

/**
 * 
 * @author Arkadii
 * @description Class for admin usage, it contains forms and tables and reviewing and adding data to the database. 
 *
 */
public class AdminPane extends EntryPane {

	/**
	 * @param conn
	 */
	public AdminPane(Connector conn) {
		this(conn, true);
	}
	
	public AdminPane(Connector conn, boolean autoInit) {
		super(conn);
		
		if(autoInit) initTabs();
	}
	
	
	@Override
	public void initTabs() {
		this.getTabs().clear();
		super.initTabs();
		Tab tab;
		
		tab = new Tab("Users", makeUsersPane());
		tab.setClosable(false);
		this.getTabs().add(tab);
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
