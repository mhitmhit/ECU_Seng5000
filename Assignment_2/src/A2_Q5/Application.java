package A2_Q5;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Student information:
		 */
		Person studentPerson1 = new Person("john studennter", 123454, 15, 'm', "794 first street", 70477490);
		Person studentPerson2 = new Person("amy studter", 84630947, 17, 'm', "794 main street", 70477490);
		Person studentPerson3 = new Person("patrickn stude", 846487, 12, 'f', "794 fourth street", 704545490);
		
		Student student1 = new Student(3.00, "cs", 2025);
		Student student2 = new Student(3.25, "history", 2020);
		Student student3 = new Student(2.99, "Business", 2020);
		
		/**
		 * Salaried Employee information:
		 */
		Person salariedEmpPerson1 = new Person("chuck emnter", 123454, 56, 'm', "794 first street", 70477490);
		Person salariedEmpPerson2 = new Person("boby empennter", 123454, 34, 'f', "794 first street", 70477490);
		
		SalariedEmployee salary1 = new SalariedEmployee("business", "engineer", 2015, 50000);
		SalariedEmployee salary2 = new SalariedEmployee("marketin", "engineer", 2012, 70000);
		
		/**
		 * Hourly Employee information:
		 */
		Person hourlyEmpPerson1 = new Person("brad dennter", 123454, 45, 'm', "794 first street", 70477490);
		Person hourlyEmpPerson2 = new Person("alex stnnter", 123454, 26, 'm', "794 first street", 70477490);
		
		HourlyEmployee hourly1 = new HourlyEmployee("cs", "programmer", 2020, 45, 40, 2);
		HourlyEmployee hourly2 = new HourlyEmployee("maint", "engineer", 2015, 60, 40, 3);
		
		/**
		 * Student Table printing
		 */
		System.out.println("STUDENT LIST:");
		System.out.printf("%12s %6s %8s %10s %15s %8s %10s %6s\n","NAME","AGE", "GENDER", "ADDRESS", "PHONE", "GPA", "MAJOR", "CLASS");
		System.out.printf("%12s %6s %8s %10s %15s %8s %10s %6s \n","----","---", "-----", "-------", "-----", "---", "-----", "----");
		System.out.printf("%15s %3d %5s %20s %10d %6s %10s %6d \n", studentPerson1.getName(), studentPerson1.getAge(), studentPerson1.getGender(), 
				studentPerson1.getAddress(), studentPerson1.getTelephone(), student1.getGpa(), student1.getMajor(), student1.getYearOfGraduation() );
		System.out.printf("%15s %3d %5s %20s %10d %6s %10s %6d \n", studentPerson2.getName(), studentPerson2.getAge(), studentPerson2.getGender(), 
				studentPerson2.getAddress(), studentPerson2.getTelephone(), student2.getGpa(), student2.getMajor(), student2.getYearOfGraduation() );
		System.out.printf("%15s %3d %5s %20s %10d %6s %10s %6d \n", studentPerson3.getName(), studentPerson3.getAge(), studentPerson3.getGender(), 
				studentPerson3.getAddress(), studentPerson3.getTelephone(), student3.getGpa(), student3.getMajor(), student3.getYearOfGraduation() );
		System.out.printf("%50s \n \n \n", "--------------");
		
		/**
		 * Hourly Employee printing
		 */
		System.out.println("HOURLY EMP LIST:");
		System.out.printf("%12s %6s %8s %10s %15s %8s %10s %15s %6s %7s %5s \n","NAME","AGE","GENDER","ADDRESS","PHONE","DEPT","JOB","YEAR","RATE","HOURS","DUES");
		System.out.printf("%12s %6s %8s %10s %15s %8s %10s %15s %6s %7s %5s \n","----","---","------","-------","-----","----","---","----","----","-----","----");
		
		System.out.printf("%15s %3d %5s %20s %10d %6s %15s %10d %6.2f %6.2f %6.2f\n", hourlyEmpPerson1.getName(), hourlyEmpPerson1.getAge(), hourlyEmpPerson1.getGender(), 
				hourlyEmpPerson1.getAddress(), hourlyEmpPerson1.getTelephone(), hourly1.getDepartment(), hourly1.getJobTitle(), hourly1.getYearOfHire(), hourly1.getHourlyRate(), 
				hourly1.getHoursWorked(), hourly1.getUnionDues() );
		System.out.printf("%15s %3d %5s %20s %10d %6s %15s %10d %6.2f %6.2f %6.2f\n", hourlyEmpPerson2.getName(), hourlyEmpPerson2.getAge(), hourlyEmpPerson2.getGender(), 
				hourlyEmpPerson2.getAddress(), hourlyEmpPerson2.getTelephone(), hourly2.getDepartment(), hourly2.getJobTitle(), hourly2.getYearOfHire(), hourly2.getHourlyRate(), 
				hourly2.getHoursWorked(), hourly2.getUnionDues() );
		System.out.printf("%50s \n \n \n", "--------------");
		
		/**
		 * Salaried Employee printing
		 */
		System.out.println("Salaried EMP LIST:");
		System.out.printf("%12s %6s %8s %10s %15s %8s %10s %12s %8s  \n","NAME","AGE","GENDER","ADDRESS","PHONE","DEPT","JOB","YEAR","SALARY");
		System.out.printf("%12s %6s %8s %10s %15s %8s %10s %12s %8s  \n","----","---","------","-------","-----","----","---","----","------");
		System.out.printf("%15s %3d %5s %20s %10d %6s %12s %8d %8.0f \n", salariedEmpPerson1.getName(), salariedEmpPerson1.getAge(), salariedEmpPerson1.getGender(), 
				salariedEmpPerson1.getAddress(), salariedEmpPerson1.getTelephone(), salary1.getDepartment(), salary1.getJobTitle(),
				salary1.getYearOfHire(), salary1.getAnnualSalary() );
		System.out.printf("%15s %3d %5s %20s %10d %6s %12s %8d %8.0f \n", salariedEmpPerson2.getName(), salariedEmpPerson2.getAge(), salariedEmpPerson2.getGender(), 
				salariedEmpPerson2.getAddress(), salariedEmpPerson2.getTelephone(), salary2.getDepartment(), salary2.getJobTitle(),
				salary2.getYearOfHire(), salary2.getAnnualSalary() );
		System.out.printf("%50s \n \n \n", "--------------");
	}

}
