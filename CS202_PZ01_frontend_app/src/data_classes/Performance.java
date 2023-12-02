package data_classes;

import java.util.Date;

import util.SmallDate;

public class Performance {
	public int id;
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String playName;
	public String getPlayName() { return playName; }
	public void setPlayName(String playName) { this.playName = playName; }

	public Date date;
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }

	public SmallDate getDate_s() { return SmallDate.fromDate(date); }
	
	public Integer ticketPrice;
	public Integer getTicketPrice() { return ticketPrice; }
	public void setTicketPrice(Integer ticketPrice) { this.ticketPrice = ticketPrice; }

	@Override
	public String toString() {
		return "Performance [id=" + id + ", playName=" + playName 
				+ ", date=" + date + ", ticketPrice=" + ticketPrice + "]";
	}
}
