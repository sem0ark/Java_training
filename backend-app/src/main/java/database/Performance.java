package database;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "performances")
public class Performance {
	@DatabaseField(generatedId = true)
	private int id;
 
	@DatabaseField(defaultValue = "")
    private String playName;
 
	@DatabaseField
	private Date date;
	
	@DatabaseField
	private int ticketPrice; // for simplicity the ticket price is set to whole

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
