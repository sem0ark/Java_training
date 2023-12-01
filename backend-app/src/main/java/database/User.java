package database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author Arkadii
 *
 */
@DatabaseTable(tableName = "users")
public class User {

	public static final String ID_FIELD_NAME = "id";
	@DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
	private int id;
	
	public static final String USERNAME_FIELD_NAME = "username";
	@DatabaseField(canBeNull = false, columnName = USERNAME_FIELD_NAME)
    private String username;

	public static final String EMAIL_FIELD_NAME = "email";
	@DatabaseField(canBeNull = false, columnName = EMAIL_FIELD_NAME)
	private String email;
 

	User() {
		// for ORMLite
	}
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	 
	public void setUsername(String username) {
		this.username = username;
	}
	 
	public String getEmail() {
		return email;
	}
	 
	public void setEmail(String email) {
		this.email = email;
	}
}