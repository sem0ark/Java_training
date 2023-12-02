package application;

import java.time.Instant;
import java.util.Date;

import data_classes.Performance;
import data_classes.User;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import network.Connector;
import util.Factory;
import util.SmallDate;
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
		Tab tab;
		
		tab = new Tab("Performances", makePerformancesPane());
		tab.setClosable(false);
		this.getTabs().add(tab);
	}
	
	private BorderPane makePerformancesPane() {
		BorderPane b = new BorderPane();
		
		System.out.println(new SmallDate(System.currentTimeMillis()).toString()); 
		
		b.setCenter(
			(new TableBuilder<Performance>())
				.<String>addColumn("Play", "playName")
				.<SmallDate>addColumn("Date", "date")
				.<Integer>addColumn("Price ($)", "ticketPrice")
			.addAll(conn.getPerformances()).build()
		);
		return b;
	}
	
}
