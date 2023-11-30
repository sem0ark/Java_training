package database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
 
@DatabaseTable(tableName = "users")
public class User {
	@DatabaseField(generatedId = true)
	private int id;
 
	@DatabaseField
    private String username;
 
	@DatabaseField
	private String email;
 
	User() {
		// for ORMLite
	}
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
	}
}