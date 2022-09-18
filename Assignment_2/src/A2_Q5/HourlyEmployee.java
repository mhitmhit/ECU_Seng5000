package A2_Q5;

public class HourlyEmployee {
	/**
	 * Attributes for hourly Employees
	 */
	private String department;
	private String jobTitle;
	private int yearOfHire;
	private double hourlyRate;
	private double hoursWorked;
	private double unionDues;
	
	/**
	 * Constructor
	 */
	public HourlyEmployee(String employeeDepartment, String employeeJobTitle, int empYearOfHire, double empHourly, double empHours, double empUnion) {
		department = employeeDepartment;
		jobTitle = employeeJobTitle;
		yearOfHire = empYearOfHire;
		hourlyRate = empHourly;
		hoursWorked = empHours;
		unionDues = empUnion;
	}
	
	/**
	 * Methods to get hourly employee attributes
	 */
	public String getDepartment() {
		return department;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public int getYearOfHire() {
		return yearOfHire;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public double getUnionDues() {
		return unionDues;
	}

}
