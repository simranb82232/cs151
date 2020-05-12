package part1;

import java.util.*;

public class Hospital {
	private ArrayList<Employee> employeeList;
	private ArrayList<Paitent> patientList;
	
	public Hospital(ArrayList<Employee> employees, ArrayList<Patient> patients) {
		//initializes employeeList and patientList using the arguments
	}
	
	public boolean addEmployee(Employee employee) {
		//adds employee to employeeList, returns true if successful, false if not
	}
	
	public boolean addPatient(Patient patient) {
		//adds patient to patientList, returns true if successful, false if not
	}
	
	public boolean removeEmployee(Employee employee) {
		//removes employee form employeeList, returns true if successful, false if not
	}
	
	public boolean removePatient(Patient patient) {
		//removes patient form patientList, returns true if successful, false if not
	}
	
	public ArrayList<Employee> getEmployees() {
		//returns employeeList
	}
	
	public ArrayList<Patient> getPatients() {
		//returns patientList
	}
}
