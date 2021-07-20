package tutorial_1;

public class Food {
	private String name;
	private int amount;
	Food(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		String str = "Food("+name+","+amount+")";
		return str;
	}
}
