package test;

public class Student {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	public boolean equals(Student other) {
		return this.name == other.name;
	}
	
	public int compareTo(Student other) {
		return this.name.compareTo(other.name);
	}
	
	public String toString() {
		return "Student "+this.name;
	}
}
