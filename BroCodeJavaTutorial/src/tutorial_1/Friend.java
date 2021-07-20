package tutorial_1;

public class Friend {
	static int numberOfFriends;
	private String name;
	
	Friend(String name) {
		this.name = name;
		Friend.numberOfFriends++;
	}
	
	public String toString() {
		return String.format("Friend(%s)", name);
	}
	
	static public void displayNumberOfFriends() {
		System.out.println(Friend.numberOfFriends);
	}
}
