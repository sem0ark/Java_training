package application;

import data_classes.Performance;
import data_classes.User;
import javafx.scene.layout.GridPane;
import network.Connector;
import util.Factory;

public class TestPane extends GridPane {
	Connector conn;
	
	public TestPane(Connector conn) {
		super();
		this.conn = conn;
		
		this.add(Factory.button("Print Users", e -> { for(User u : conn.getUsers()) System.out.println(u); }), 0, 0);
		this.add(Factory.button("Print User", e -> { System.out.println(conn.getUser(1)); }), 0, 1);
		this.add(Factory.button("Print Performances", e -> { for(Performance p : conn.getPerformances()) System.out.println(p); }), 1, 0);
	}
}
