package DBTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import database.DatabaseConnector;
import database.Performance;
import database.Reservation;
import database.User;
import util.Config;
import util.Util;

class ReservationTest {
	public DatabaseConnector conn = new DatabaseConnector(Config.DATABASE_URL_TEST);
	
	@Before
	public void clearDB() {
		try {
			conn.dropReservation();
		} catch (SQLException e) {
			System.err.println("Failed dropping DB");
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_reservationAdd() throws SQLException, ParseException {
		Performance performance = new Performance("playName", Util.parseDate("2023-11-10"), 20);
		conn.getPerformanceDao().create(performance);
		
		User user = new User("username", "email@email.com");
		conn.getUserDao().create(user);
        
        Reservation reservation = new Reservation(performance, user, 5);
        conn.getReservationDao().create(reservation);
		
		Reservation result = conn.getReservationDao().queryForId(Integer.toString(reservation.getId()));
        
        assertEquals(reservation.getId(), result.getId());
        assertEquals(reservation.getPerformance().getId(), result.getPerformance().getId());
        assertEquals(reservation.getUser().getId(), result.getUser().getId());
        assertEquals(reservation.getReservedSeats(), result.getReservedSeats());
	}
}




