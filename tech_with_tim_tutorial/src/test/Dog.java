package test;

public class Dog {
	
	protected static int count = 0;
	
	protected String name;
	protected int age;
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
		Dog.count++;
//		Dog.display();
	}
	
	public void speak() {
		System.out.println("I am " + this.name + ". I am " + this.age + " years old."); 
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	private int add2() {
		return this.age + 2;
	}
	
	public int getCount() {
		return Dog.count;
	}
	
	public static void display() {
		System.out.println("I am a dog!");
	}
}
