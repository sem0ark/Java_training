package data_classes;

public class User {
	public int id;
	public String username;
	public String email;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
	}
}
