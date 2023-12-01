package DBTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import database.DatabaseConnector;
import database.User;
import util.Config;


class UserTest {
	public DatabaseConnector conn = new DatabaseConnector(Config.DATABASE_URL_TEST);
	
	@Before
	public void clearDB() {
		try {
			conn.dropUser();
		} catch (SQLException e) {
			System.err.println("Failed dropping DB");
			e.printStackTrace(); 
		}
	}
	
	@Test
	public void test_userAdd() throws SQLException, ParseException {
		User user = new User("username", "email@email.com");
		conn.getUserDao().create(user);
		User result = conn.getUserDao().queryForId(Integer.toString(user.getId()));
        
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getEmail(), result.getEmail());
	}
}
