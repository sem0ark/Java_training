package application;


import data_classes.Performance;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import network.Connector;
import util.Factory;
import util.Factory.OuterHandler;
import util.SmallDate;
import util.TableBuilder;

/**
 * 
 * @author Arkadii
 * @description Implementation of the main UI component in a form of tabbed application.
 * 				The user will be able to interact with the application b yswitching between tabs, which will contain more specialized functionality.
 *
 */
public class EntryPane extends TabPane {
	Connector conn;

	/**
	 * how clicking on the performances table row should be handled
	 * can be overwritten in inheriting panes.
	 */
	protected OuterHandler<Performance, TableView<Performance>> performanceHandler = (e, p) -> {
		Platform.runLater(() -> {
			p.getSelectionModel().clearSelection();
		});
	};
	
	/**
	 * @param conn
	 */
	public EntryPane(Connector conn) {
		this(conn, true);
	}
	
	/**
	 * @param conn
	 * @param autoInit
	 */
	public EntryPane(Connector conn, boolean autoInit) {
		super();
		this.conn = conn;
		
		if(autoInit) initTabs();
	}
	
	
	/**
	 * Main function for tabs initialization, it will be used for initializing the UI components.
	 */
	public void initTabs() {
		this.getTabs().clear();
		Tab tab;
		
		tab = new Tab("Performances", makePerformancesPane());
		tab.setClosable(false);
		this.getTabs().add(tab);
	}
	
	/**
	 * @return
	 */
	private BorderPane makePerformancesPane() {
		BorderPane b = new BorderPane();
		
		b.setTop(Factory.choice(new Integer[] {0, 5, 10, 30, 100}, e -> {
			if(e == 0) b.setCenter(makePerformanceTable(performanceHandler));
			else b.setCenter(makePerformanceTableNear(e, performanceHandler));
		}));
		BorderPane.setMargin(b.getTop(), new Insets(10));
		return b;
	}
	
	/**
	 * @param handler
	 * @return
	 */
	private TableView<Performance> makePerformanceTable(OuterHandler<Performance, TableView<Performance>> handler) {
		return (new TableBuilder<Performance>())
				.setHandler(handler)
				.<String>addColumn("Play", "playName")
				.<SmallDate>addColumn("Date", "date_s")
				.<Integer>addColumn("Price ($)", "ticketPrice")
			.addAll(conn.getPerformances()).build();
	}
	
	/**
	 * @param days
	 * @param handler
	 * @return
	 */
	private TableView<Performance> makePerformanceTableNear(int days, OuterHandler<Performance, TableView<Performance>> handler) {
		return (new TableBuilder<Performance>())
				.setHandler(handler)
				.<String>addColumn("Play", "playName")
				.<SmallDate>addColumn("Date", "date_s")
				.<Integer>addColumn("Price ($)", "ticketPrice")
			.addAll(conn.getPerformances(days)).build();
	}
}
