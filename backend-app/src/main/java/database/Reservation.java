package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author Arkadii
 *
 */
@DatabaseTable(tableName = "reservations")
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
	
	private Integer totalPrice;

	public static List<Reservation> queryFindByUser(DatabaseConnector conn, int userId) {
		
		try {
			PreparedQuery<Reservation> q = conn.getReservationDao().queryBuilder().where().eq(USER_FIELD_NAME, userId).prepare();
			System.out.println("INFO: query " + q.toString());
			
			Dao<Performance, String> performanceDao = conn.getPerformanceDao();
			List<Reservation> result = conn.getReservationDao().query(q);
			
			for(Reservation r : result) r.calculateTotalPrice(performanceDao);			
			return result;
		} catch (SQLException e) {
			System.err.println("Failed running query");
			e.printStackTrace(System.err);
		}
		
		return new ArrayList<Reservation>(); 
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
	
	
	public void calculateTotalPrice(Dao<Performance, String> dao)  {
		try {
			this.performance = dao.queryForId(Integer.toString(this.getPerformance().getId()));
			this.setTotalPrice(this.performance.getTicketPrice() * this.reservedSeats);
		} catch (SQLException e) {
			this.setTotalPrice(0);
		}
	}
	
	@Override
	public String toString() {
		return "Reservation [perf=" + performance.getId() + ", user=" + user.getId() + ", reservedSeats=" + reservedSeats + "]";
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

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
}
