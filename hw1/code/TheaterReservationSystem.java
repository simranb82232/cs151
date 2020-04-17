package trs;
import java.time.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class TheaterReservationSystem {
	private static String userName;
	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	public static boolean signUp(String id, String pwd) {
		User u = new User(id, pwd);
		return u.signUp();
	}
	public static boolean signIn(String id, String pwd) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("users.txt")); 
		String i; 
		while ((i=br.readLine()) != null) {
			if (i.equals(id)) {
				if (br.readLine().equals(pwd)) {
					br.close();
					return true;
					}
				br.close();
				System.out.println("Invalid Password");
				return false;
				}
		}
		br.close();
		System.out.println("Invalid user id");
		return false;	
	} 
	
	public static void main(String[] args) {
		File file = new File("reservations.txt");
		double con = 10;
		try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String l = "s";
		while (l != null) {
			con++;
			l = br.readLine();
		}
		} catch (Exception e) {
			System.out.print("");
		}
		String user = "";
		while (true) {
		System.out.println("Sign [U]p   Sign [I]n   E[X]it");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		while (!(input.equals("U") || input.equals("I") || input.equals("X"))) {
			System.out.println("Error: Invalid Input");
			input = scan.next();
		}
		if (input.equals("U")) {
			System.out.println("Enter a user id: ");
			String userName = scan.next();
			System.out.println("Enter a password: ");
			String passWord = scan.next();
			if (signUp(userName, passWord) == false) {
				System.out.println("A user with that id already exists.");
			}
			continue;
		}
		if (input.equals("I")) {
			System.out.println("Enter your user id: ");
			user = scan.next();
			userName = user;
			System.out.println("Enter your password: ");
			String pass = scan.next();
			try {
				if (signIn(user, pass) == false) {
					continue;
				}
				} catch (Exception e) {
					System.out.println("Input error");
				}
		}
		if (input.equals("X")) {
			System.out.println("Goodbye.");
			break;
		}
		while (true) {
			System.out.println("[R]eserve    [V]iew    [C]ancel    [O]ut");
			input = scan.next();
			if (input.equals("R")) {
				System.out.println("Enter the date of the show you want to see in the format yyyy-MM-dd: ");
				String date = scan.next();
				System.out.println("Enter the time of the show you want to see in the format hh-mm: ");
				String time = scan.next();
				LocalDate showDate = LocalDate.parse(date);
				Reservation r = new Reservation(showDate, time);
				Show show = new Show(showDate, time);
				boolean rSeats = false;
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					System.out.println("Seats not available:");
					String l;
					while (true) {
						l = br.readLine();
						if (l.equals(date)) {
							if (br.readLine().equals(time)) {
								rSeats = true;
								l = br.readLine();
								while (Integer.parseInt(l.substring(l.length() - 1)) >= 0) {
									System.out.print(l + " ");
									l = br.readLine();
								}
								break;
							}
					}
					}
					br.close();
					if (reservations.size() > 0) {
						for (Reservation res : reservations) {
							if (res.getDate().equals(date) && res.getTime().equals(time)) {
								for (Seat se : res.seats) {
									System.out.print(se.toString() + " ");
								}
							}
						}
					}
					} catch (Exception e) {
						System.out.print("");
					}
				if (rSeats == false) {
					System.out.print("(none)");
				}
				boolean loop = true;
				while (loop) {
					System.out.println("\nEnter a section: ");
					String sec = scan.next();
					Section s = new Section(sec);
					System.out.println("Enter a seat number between 1 and " + s.getMax());
					int number = Integer.parseInt(scan.next());
					for (Seat x : show.getSeats()) {
						if(sec.equals(x.getSection()) && number == x.getNumber()) {
							System.out.println("Seat is not available");
							continue;
						}
					}
					boolean cont = false;
					if (reservations.size() > 0) {
						for (Reservation i : reservations) {
							for (Seat j : i.seats) {
								if (i.getDate() == date && i.getTime().equals(time)) {
									if(sec.equals(j.getSection()) && number == j.getNumber()) {
										System.out.println("Seat is not available");
										cont = true;
										break;
									}
								}
							}
						}
						if (cont == true) {
							continue;
						}
					}
					r.addSeat(new Seat(sec, number));
					show.addTakenSeat(new Seat(sec, number));
					System.out.println("Enter A to add another seat or C to confirm");
					String input2 = scan.next();
					if (input2.equals("C")) {
						reservations.add(r);
						break;
					}
					}
				if (reservations.size() > 0) {
					try {
					FileWriter fw = new FileWriter("reservations.txt",true); 
				    fw.write("\n" + user + "\n");
				    for (Reservation x : reservations) {
				    	fw.write(x.getDate() + "\n" + x.getTime() + "\n" + x.getSeats());
				    }
				    fw.close();
				} catch(IOException ioe) {
				    System.out.println("IOException: " + ioe.getMessage());
				}
				}
				}
		if (input.equals("V")) {
			System.out.println("View [c]urrent reservations or [a]ll reservations?");
			String in = scan.next();
			if (in.equals("a")) {
				boolean hasReservations = false;
				try {
					BufferedReader br = new BufferedReader(new FileReader("reservations.txt"));
					String reader = br.readLine();
					System.out.print("Your reservations: ");
					while (reader != null) {
						if (reader.equals(userName)) {
							System.out.println("\n" + br.readLine() + " " 
									+ br.readLine() + ": ");
							reader = br.readLine();
							while (reader != null) {
								if (!reader.equals(userName)) {
									System.out.print(reader + " ");
								}
								if (reader.equals("")) {
									break;
								}
								if (reader.equals(userName)) {
									break;
								}
								reader = br.readLine();
							}
							hasReservations = true;
						}
						if (!reader.equals(userName)) {
							reader = br.readLine();
						}
					}
					if (hasReservations == false) {
						System.out.println("No reservations found");
					}
					System.out.print("\n");
				} catch (Exception e){
					System.out.print("\n");
				}
			} else {
				if (reservations.size() > 0) {
					for(int n = reservations.size() - 1; n > 0; n--) {
						System.out.println(reservations.get(n).getDate()
								+ " " + reservations.get(n).getTime() + " "
								+ reservations.get(n).getSeats());
					}
				}
			}
			}
		if (input.equals("C")) {
			if (reservations.size() == 0) {
				System.out.println("No seats to cancel");
				continue;
			}
			String dateCancel;
			String timeCancel;
			Seat seatCancel;
			String sectionCancel;
			int numCancel;
			Scanner scann = new Scanner(System.in);
			System.out.println("You have chosen to cancel one or more seats."
					+ " Enter the date in yyyy-mm-dd format: ");
			dateCancel = scann.next();
			System.out.println("Enter the time in hh-mm format: ");
			timeCancel = scann.next();
			for (Reservation r : reservations) {
				if (r.getDate().toString().equals(dateCancel) && r.getTime().equals(timeCancel)) {
						System.out.println("Your reserved seats for this show: ");
						System.out.print(r.getSeats());
						System.out.println("Enter a section for the seat you wish to cancel: ");
						sectionCancel = scann.next();
						System.out.println("Enter the seat number to cancel: ");
						numCancel = Integer.parseInt(scann.next());
						seatCancel = new Seat(sectionCancel, numCancel);
						for (int i = 0; i < r.seats.size() - 1; i ++) {
							if (r.seats.get(i).getSection().equals(seatCancel.getSection()) && r.seats.get(i).getNumber() == seatCancel.getNumber()) {
								r.removeSeat(r.seats.get(i));
							}
						}
					}
				}
			continue;
			}
		if (input.equals("O")) {
			if (reservations.size() > 0) {
				Receipt receipt = new Receipt(reservations, con);
				receipt.printReceipt();
			}
			break;
		}
		}
	}
		System.out.println("Program exited. ");
	}
}
