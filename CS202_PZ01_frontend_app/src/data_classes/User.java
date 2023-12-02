package data_classes;

public class User {
	public int id;
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String username;
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String email;
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
	}
}
