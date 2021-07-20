package tutorial_1;

public class Hero extends Person{
	private String power;
	
	Hero(String name, int age, String power) {
		super(name, age);
		this.power = power;
	}
	
	@Override
	public String toString() {
		return String.format("Hero(%s, %d, %s)", name, age, power);
	}
}
