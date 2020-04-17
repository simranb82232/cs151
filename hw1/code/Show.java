package trs;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.*;
import java.util.*;

public class Show {
	private LocalDate date;
	private String time;
	private ArrayList<Seat> seatsTaken = new ArrayList<Seat>();
	public Show(LocalDate d, String t) {
		date = d;
		time = t;
	}
	public void addTakenSeat(Seat s) {
		seatsTaken.add(s);
	}
	public ArrayList<Seat> getSeats() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("reservations.txt"));
			String l;
			while (true) {
				l = br.readLine();
				if (l.equals(date)) {
					if (br.readLine().equals(time)) {
						l = br.readLine();
						while (l.length() < 6) {
							String sec = l.substring(0, 2);
							int num = Integer.parseInt(l.substring(2));
							seatsTaken.add(new Seat(sec, num));
							l = br.readLine();
						}
						break;
					}
			}
			}
			br.close();
			} catch (Exception e) {
				System.out.print("");
			}
		return seatsTaken;
	}
}
