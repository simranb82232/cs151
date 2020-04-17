package trs;

import java.util.ArrayList;

public class Receipt {
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private double confirmation;
	public Receipt(ArrayList<Reservation> r, double c) {
		for (Reservation x : r) {
			reservations.add(x);
		}
		confirmation = c;
	}
	public void printReceipt() {
		double totalPrice = 0;
		boolean same = false;
		boolean fDiscount = false;
		boolean tDiscount = false;
		ArrayList<Reservation> sameShow = new ArrayList<Reservation>();
		System.out.println("Confirmation number: " + confirmation);
		for (Reservation r : reservations) {
			for (int i = reservations.indexOf(r); i < reservations.size()-1; i++) {
				if (r.getDate().equals(reservations.get(i).getDate())) {
					same = true;
					sameShow.add(r);
					sameShow.add(reservations.get(i));
				}
			}
			System.out.println("Date: " + r.getDate() + "\nTime: " + r.getTime()
					+ "\nSeats Reserved: " + r.getSeats() + "Price: $"
					+ r.getPrice()); 
			totalPrice += r.getPrice();
		}
		if (same == true) {
			ArrayList<Seat> sameSeats = new ArrayList<Seat>();
			for (Reservation y : sameShow) {
				for (Seat z : y.seats) {
					sameSeats.add(z);
				}
			}
			if (sameSeats.size() < 11) {
				for (Reservation e : sameShow) {
					if (e.seats.size() < 5) {
						fDiscount = true;
					}
					if (e.getDate().equals("2020-12-26") || e.getDate().equals("2020-12-27")) {
						fDiscount = false;
					}
				}
			}
			if (sameSeats.size() > 10) {
				for (Reservation e : sameShow) {
					if (e.seats.size() < 10) {
						tDiscount = true;
					}
					if (e.getDate().equals("2020-12-26") || e.getDate().equals("2020-12-27")) {
						tDiscount = false;
					}
				}
			}
			if (same == true && tDiscount == true) {
				for (Reservation e : sameShow) {
					for (Seat f : e.seats) {
						totalPrice = totalPrice - 5;
					}
				}
			} else if (same == true && fDiscount == true) {
				for (Reservation e : sameShow) {
					for (Seat g : e.seats) {
						totalPrice = totalPrice - 2;
					}
				}
			}
		}
 		System.out.println("Total Price: $" + totalPrice);
	}
}
