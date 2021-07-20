package tutorial_1;

public class Pizza {
	String sauce;
	String bread;
	String cheese;
	String topping;
	
	Pizza(String bread, String sauce, String cheese, String topping) {
		this.sauce = sauce;
		this.bread = bread;
		this.cheese = cheese;
		this.topping = topping;
	}
	
	Pizza(String bread, String sauce, String cheese) {
		this.sauce = sauce;
		this.bread = bread;
		this.cheese = cheese;
	}
	
	Pizza(String bread, String sauce) {
		this.sauce = sauce;
		this.bread = bread;
	}
	
	Pizza(String bread) {
		this.bread = bread;
	}
	
	Pizza() {
		
	}
}
