package trs;
import java.time.*;
import java.util.*;

public class Reservation {
	private LocalDate date;
	private String time;
	public ArrayList<Seat> seats = new ArrayList<Seat>();
	public boolean fiveDiscount = false;
	public boolean tenDiscount = false;
	public boolean dNight = false;
	
	public Reservation(LocalDate d, String t) {
		date = d;
		time = t;
	}
	public void addSeat(Seat s) {
		seats.add(s);
	}
	public String getDate() {
		return date.toString();
	}
	public String getTime() {
		return time;
	}
	public String getSeats() {
		String seatList = "";
		for (Seat s : seats) {
			seatList += s.toString() + "\n";
		}
		return seatList;
	}
	public void removeSeat(Seat s) {
		int index = seats.indexOf(s);
		seats.remove(index);
	}
	public double getPrice() {
		double price = 0;
		for (Seat s : seats) {
			price += s.getPrice();
		}
		if (date.toString().equals("2020-12-26") || date.toString().equals("2020-12-27")) {
			for (Seat s : seats) {
				price = price - 20;
			}
		}
		if (seats.size() >= 5 && seats.size() <= 10 && !(date.toString().equals("2020-12-26") || date.toString().equals("2020-12-27"))) {
			for (Seat s : seats) {
				price = price - 2;
			}
			fiveDiscount = true;
		}
		if (seats.size() >= 11 && seats.size() <= 20 && !(date.toString().equals("2020-12-26") || date.toString().equals("2020-12-27"))) {
			for (Seat s : seats) {
				price = price - 5;
			}
			tenDiscount = true;
		}
		return price;
	}
}
