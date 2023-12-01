package database;

import com.j256.ormlite.field.DatabaseField;

public class Reservation {
	
	public static final String ID_FIELD_NAME = "id";
	@DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
	private int id;
	
	public static final String PERFORMANCE_FIELD_NAME = "performance";
	@DatabaseField(foreign = true, canBeNull = false, columnName = PERFORMANCE_FIELD_NAME)
	private Performance performance;
	
	public static final String USER_FIELD_NAME = "user";
	@DatabaseField(foreign = true, canBeNull = false, columnName = USER_FIELD_NAME)
	private User user;
	
	public static final String SEATS_FIELD_NAME = "reservedSeats";
	@DatabaseField(canBeNull = false, columnName = SEATS_FIELD_NAME)
	private int reservedSeats;

	@Override
	public String toString() {
		return "Reservation [perf=" + performance.getId() + ", user=" + user.getId() + ", reservedSeats=" + reservedSeats + "]";
	}	
	
	Reservation() {
		// required for ORMlite
	}
	
	public Reservation(Performance performance, User user, int reservedSeats) {
		super();
		this.performance = performance;
		this.user = user;
		this.reservedSeats = reservedSeats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
}
