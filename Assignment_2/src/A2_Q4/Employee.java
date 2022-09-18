package A2_Q4;

public class Employee {
	
	private String name;
	private double salary;
	
	/**
	 * Construct an employee with name and salary
	 * @param employeeName
	 * @param currentSalary
	 */
	public Employee(String employeeName, double currentSalary) {
		name = employeeName;
		salary = currentSalary;
	}
	
	/**
	 * gets the current employee name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets the current employee salary
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * raises the salary of the employee with given percentage
	 * @param byPercent
	 */
	public void raiseSalary(double byPercent) {
		salary = salary + (salary * (byPercent/100)) ;
	}
	
}
