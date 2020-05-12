package part1;

public class Patient {
	private String name;
	private int roomNumber;
	private String condition;
	private String treatment;
	private Doctor doctor;
	
	public Patient(String n, int r, String c) {
		//initializes name, roomNumber, and condition to the arguments
	}
	public String getName() {
		//returns name
	}
	
	public int getRoomNumber() {
		//returns roomNumber
	}
	
	public String getCondition() {
		//returns condition
	}
	
	public String getTreatment() {
		//returns treatment
	}
	
	public void assignRoom(int room) {
		//sets roomNumber equal to the argument
	}
	
	public void setTreatment(String medicine) {
		//sets treatment equal to the argument
	}
	
	public void assignDoctor(Doctor doc) {
		//sets doctor equal to the argument
	}
}
