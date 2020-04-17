package trs;

public class Seat {
	private String section;
	private int number;
	private int price;
	public Seat(String s, int n) {
		section = s;
		number = n;
	}
	public String toString() {
		return section + Integer.toString(number);
	}
	public String getSection() {
		return section;
	}
	public int getNumber() {
		return number;
	}
	public int getPrice() {
		price = 0;
		if (section.equals("mf")) {
			if (number <= 100) {
				price = 35;
			} else {
				price = 45;
			}
		}
		if (section.equals("sb")) {
			if (number <= 25) {
				price = 50;
			} else {
				price = 55;
			}
		}
		if (section.equals("wb") || section.equals("eb")) {
			price = 40;
		}
		return price;
	}
}
