package DBTests;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import database.DatabaseConnector;
import database.Performance;
import util.Config;
import util.Util;

class PerformanceTest {
	public DatabaseConnector conn = new DatabaseConnector(Config.DATABASE_URL_TEST);
	
	@Before
	public void clearDB() {
		try {
			conn.dropPerformance();
		} catch (SQLException e) {
			System.err.println("Failed dropping DB");
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_performanceAdd() throws SQLException, ParseException {
		Performance performance = new Performance("playName", Util.parseDate("2023-11-10"), 20);
		conn.getPerformanceDao().create(performance);
        
        Performance result = conn.getPerformanceDao().queryForId(Integer.toString(performance.getId()));
        
        assertEquals(result.getId(), performance.getId());
        assertEquals(result.getPlayName(), performance.getPlayName());
        assertEquals(result.getDate(), performance.getDate());
        assertEquals(result.getTicketPrice(), performance.getTicketPrice());
	}
}
