package test;

public class Car implements Vehicle {
	private int gear=1, speed=0;
	
	public void speedUp(int change) {
		this.speed += change;
	}
	
	public void slowDown(int change) {
		this.speed -= change;
	}
	
	public void changeGear(int gear) {
		this.gear = gear;
	}

	public void display() {
		System.out.println("I am car and I am going " + this.speed + "km/h and at gear " + this.gear);
		out();
	}
}
