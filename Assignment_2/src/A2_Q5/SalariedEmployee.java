package A2_Q5;

public class SalariedEmployee {
	/**
	 * Attributes for salaried Employees
	 */
	private String department;
	private String jobTitle;
	private int yearOfHire;
	private double annualSalary;
	
	public SalariedEmployee(String employeeDepartment, String employeeJobTitle, int empYearOfHire, double empSalary) {
		department = employeeDepartment;
		jobTitle = employeeJobTitle;
		yearOfHire = empYearOfHire;
		annualSalary = empSalary;
	}

	/**
	 * Methods to get salaried employee attributes
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
	public double getAnnualSalary() {
		return annualSalary;
	}

	
}
