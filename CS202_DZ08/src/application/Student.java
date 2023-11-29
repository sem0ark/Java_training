package application;

import java.util.Objects;

public class Student {
	public String firstName, lastName, index;
	
	public Student(String firstName, String lastName, String index) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.index = index;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName)
				&& Objects.equals(index, other.index)
				&& Objects.equals(lastName, other.lastName);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, index, lastName);
	}


	@Override
	public String toString() {
		return "Student " + firstName + " " + lastName + ", " + index + "";
	}
}
