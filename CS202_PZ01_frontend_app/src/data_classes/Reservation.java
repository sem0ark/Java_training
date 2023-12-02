package data_classes;

import util.SmallDate;

public class Reservation {
	public User user;
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }

	public Performance performance;
	public Performance getPerfromance() { return performance; }
	public void setPerfromance(Performance perfromance) { this.performance = perfromance; }

	public Integer reservedSeats;
	public Integer getReservedSeats() { return reservedSeats; }
	public void setReservedSeats(Integer reservedSeats) { this.reservedSeats = reservedSeats; }

	public Integer totalPrice;
	public Integer getTotalPrice() { return totalPrice; }
	public void setTotalPrice(Integer totalPrice) { this.totalPrice = totalPrice; }

	public String playName;
	public String getPlayName() { return this.playName; }
	public void setName() { this.playName = performance.getPlayName(); }
	
	public SmallDate date;
	public SmallDate getDate() { return this.date; }
	public void setDate() { this.date = SmallDate.fromDate(performance.getDate()); }
	
	@Override
	public String toString() {
		return "Reservation [user=" + user.getId() + ", perfromance=" 
				+ performance.getId() + ", reservedSeats=" + reservedSeats + "]";
	}
}
