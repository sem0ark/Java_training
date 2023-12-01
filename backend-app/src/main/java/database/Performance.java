package database;

import java.sql.SQLException;
import java.util.Date;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.table.DatabaseTable;

import util.Util;

/**
 * 
 * @author Arkadii
 *
 */
@DatabaseTable(tableName = "performances")
public class Performance {
	
	public static final String ID_FIELD_NAME = "id";
	@DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
	private int id;
 
	public static final String PLAY_FIELD_NAME = "playName";
	@DatabaseField(canBeNull = false, columnName = PLAY_FIELD_NAME)
    private String playName;
 
	public static final String DATE_FIELD_NAME = "date";
	@DatabaseField(canBeNull = false, columnName = DATE_FIELD_NAME, dataType = DataType.DATE_LONG)
	private Date date;
	
	public static final String TICKET_FIELD_NAME = "ticketPrice";
	@DatabaseField(canBeNull = false, columnName = TICKET_FIELD_NAME)
	private int ticketPrice; // for simplicity the ticket price is set to whole
	
	public static PreparedQuery<Performance> queryFindNext(Dao<Performance, String> dao, int days) throws SQLException {
		Date start = Util.getNow();
		Date end = Util.getNowAfterDays(days);
		
		System.out.println(start);
		System.out.println(end);
		
		System.out.println(dao.queryBuilder().where().between(DATE_FIELD_NAME, start, end).prepare());
		return dao.queryBuilder().where().between(DATE_FIELD_NAME, start, end).prepare();
	}

	Performance() {
		// for ORMLite
	}
	
	public Performance(String playName, Date date, int ticketPrice) {
		this.playName = playName;
		this.date = date;
		this.ticketPrice = ticketPrice;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayName() {
		return playName;
	}

	public void setPlayName(String playName) {
		this.playName = playName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "Performance [id=" + id + ", playName=" + playName + ", ticketPrice=" + ticketPrice
				+ "]";
	}
}
