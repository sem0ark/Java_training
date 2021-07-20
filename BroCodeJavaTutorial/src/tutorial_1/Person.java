package tutorial_1;

public class Person {
	protected String name;
	protected int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.format("Person(%s, %d)", name, age);
	}
}
