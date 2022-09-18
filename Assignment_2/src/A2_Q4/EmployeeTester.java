package A2_Q4;

public class EmployeeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee harry = new Employee("hacker, harry", 50000);
		//
		
		System.out.println("the employee name is: " + harry.getName());
		System.out.println("the emplopyee salary before raise is: " + harry.getSalary());
		
		harry.raiseSalary(10);
		
		System.out.println("the employee salary after raise is: " + harry.getSalary());
	}
}
