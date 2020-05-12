package part1;

public class Doctor extends Employee {
	private String name;
	private int employeeID;
	private double salary;
	private Patient patient;
	
	public Doctor(String n, int id, double sal) {
		//calls the superclass constructor to initialize name, employeeID, and salary
	}
	
	public void assignPatient(Patient patient) {
		//sets patient to the argument value
	}
	
	public String givePatientPrescription() {
		//returns a prescription in the form of a String based on the condition instance
		// variable of patient
	}
}
