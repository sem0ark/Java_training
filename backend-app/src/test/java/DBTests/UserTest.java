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
	public static DatabaseConnector conn = new DatabaseConnector(Config.DATABASE_URL_TEST);
	
	@Before
	public void clearDB() {
		try {
			UserTest.conn.dropUser();
		} catch (SQLException e) {
			System.err.println("Failed dropping DB");
			e.printStackTrace(); 
		}
	}
	
	@Test
	public void test_userAdd() throws SQLException, ParseException {
		User user = new User("username", "email@email.com");
		UserTest.conn.getUserDao().create(user);
        
		User result = UserTest.conn.getUserDao().queryForId(Integer.toString(user.getId()));
        
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getEmail(), result.getEmail());
	}
	
	@Test
	public void test_userQuery() throws SQLException, ParseException {
		UserTest.conn.getUserDao().create(new User("u", "e"));
		UserTest.conn.getUserDao().create(new User("u", "e"));
		UserTest.conn.getUserDao().create(new User("u", "e"));
        
        assertEquals(UserTest.conn.getUserDao().queryForAll().size(), 3);
	}
}
