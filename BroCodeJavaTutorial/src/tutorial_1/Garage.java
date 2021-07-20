package tutorial_1;

import java.util.ArrayList;

public class Garage {
	private ArrayList<Car2> parking;
	Garage() {
		this.parking = new ArrayList<Car2>();
	}
	
	public void park(Car2 car) {
		this.parking.add(car);
	}

	@Override
	public String toString() {
		return String.format("Garage(%d)", this.parking.size());
	}
	
	public void showCars() {
		for (Car2 i:this.parking) {
			System.out.println(i);
		}
	}
}
