package tutorial_1;

public class Car2 {
	private String name;
	Car2(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("Car(%s)", name);
	}
	
	
}
