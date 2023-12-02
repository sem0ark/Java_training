package application;


import data_classes.Performance;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import network.Connector;
import util.Factory;
import util.SmallDate;
import util.TableBuilder;

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
		
		b.setTop(Factory.choice(new Integer[] {0, 5, 10, 30, 100}, e -> {
			if(e == 0) b.setCenter(makePerformanceTable());
			else b.setCenter(makePerformanceTable());
		}));
		BorderPane.setMargin(b.getTop(), new Insets(10));
		
		System.out.println(new SmallDate(System.currentTimeMillis()).toString()); 
		
		
		return b;
	}
	
	TableView<Performance> makePerformanceTable() {
		return (new TableBuilder<Performance>())
				.<String>addColumn("Play", "playName")
				.<SmallDate>addColumn("Date", "date")
				.<Integer>addColumn("Price ($)", "ticketPrice")
			.addAll(conn.getPerformances()).build();
	}
	
	TableView<Performance> makePerformanceTableNear(int days) {
		return (new TableBuilder<Performance>())
				.<String>addColumn("Play", "playName")
				.<SmallDate>addColumn("Date", "date")
				.<Integer>addColumn("Price ($)", "ticketPrice")
			.addAll(conn.getPerformances(days)).build();
	}
}
