package data_classes;

import java.util.Date;

public class Performance {
	public int id;
	public String playName;
	public Date date;
	public Integer ticketPrice;
	
	@Override
	public String toString() {
		return "Performance [id=" + id + ", playName=" + playName 
				+ ", date=" + date + ", ticketPrice=" + ticketPrice + "]";
	}
}
