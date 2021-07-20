package tutorial_1;

public class Car5 {
	private String make;
	private String model;
	private int year;
	
	Car5(String make, String model, int year) {
		this.setMake(make);
		this.setModel(model);
		this.setYear(year);
	}
	
	Car5(Car5 x) {
		this.setMake(x.getMake());
		this.setModel(x.getModel());
		this.setYear(x.getYear());
	}
	
	public void copy(Car5 x) {
		this.setMake(x.getMake());
		this.setModel(x.getModel());
		this.setYear(x.getYear());
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + String.format("Car(%s, %s, %d)", this.getMake(), this.getModel(), this.getYear());
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public int getYear() {
		return year;
	}

	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
