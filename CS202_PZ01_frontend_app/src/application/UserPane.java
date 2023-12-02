package application;

import data_classes.Performance;
import data_classes.Reservation;
import data_classes.User;
import javafx.application.Platform;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import network.Connector;
import util.Factory;
import util.TableBuilder;
import util.Factory.OuterHandler;
import util.SmallDate;

public class UserPane extends EntryPane {
	
	private User user;
	private boolean selectionRunning = false;
	
	protected OuterHandler<Reservation, TableView<Reservation>> reservationHandler = (e, p) -> {
		Platform.runLater(() -> {
			p.getSelectionModel().clearSelection();
		});
	};
	
	public UserPane(Connector conn, String userId) {
		this(conn, userId, true);
	}
	
	public UserPane(Connector conn, String userId, boolean autoInit) {
		super(conn, false);
		try {
			this.user = conn.getUser(Integer.parseInt(userId));
			if(this.user == null) throw new NumberFormatException();
			
			this.performanceHandler = (e, p) -> {
				if(selectionRunning) return;
				
				selectionRunning = true;
				Factory.runChoiceDialog("Reservation", "", "no. seats", new Integer[] {
					1, 2, 3, 4, 5
				}, v -> {
					handleReservation(e, v);
					Platform.runLater(() -> {
						p.getSelectionModel().clearSelection();
						selectionRunning = false;
						this.initTabs();
					});
				});
			};
			
			Platform.runLater(() -> {
				Factory.runInfoDialog("Login", "Logged in, ID: " + this.user.getId(), "");
			});
		} catch (NumberFormatException e) {
			Factory.runInfoDialog("Fail", "Failed to login in as user, ID: " + userId, "");
		}
		
		if(autoInit) initTabs();
	}
	
	@Override
	public void initTabs() {
		this.getTabs().clear();
		super.initTabs();
		Tab tab;
		
		tab = new Tab("Reservations", makeReservationPane());
		tab.setClosable(false);
		this.getTabs().add(tab);
	}
	
	private void handleReservation(Performance p, Integer seats) {
		Integer result = conn.addReservation(this.user.getId(), p.getId(), seats);
		if(result != null) {
			Platform.runLater(() -> {
				Factory.runInfoDialog("Success", "Reserved " + seats + " seat(s) for performance " + p.getPlayName(), "");
			});
		} else {
			Platform.runLater(() -> {
				Factory.runInfoDialog("Fail", "Reservation failed", "");
			});
		}
	}
	
	private BorderPane makeReservationPane() {
		BorderPane b = new BorderPane();
		b.setCenter(makeReservationTable(reservationHandler));
		return b;
	}
	
	TableView<Reservation> makeReservationTable(OuterHandler<Reservation, TableView<Reservation>> handler) {
		return (new TableBuilder<Reservation>())
				.setHandler(handler)
				.<String>addColumn("Play", "playName")
				.<Integer>addColumn("Reserved seats", "reservedSeats")
				.<Integer>addColumn("Price ($)", "totalPrice")
				.<SmallDate>addColumn("Date", "date")
			.addAll(conn.getReservationsByUser(this.user.getId())).build();
	}
}
