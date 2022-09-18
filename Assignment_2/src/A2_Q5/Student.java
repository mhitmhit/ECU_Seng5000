package A2_Q5;

public class Student {
	/**
	 * Attributes common to all persons
	 */
//	private String name;
//	private int socialSecurityNumber;
//	private int age;
//	private char gender;
//	private String address;
//	private int telephone;
	/**
	 * Student only attributes
	 */
	private double gpa;
	private String major;
	private int yearOfGraduation;
	
	public Student(Person person, double personGpa, String personMajor, int personYearOfGraduation) {
		gpa = personGpa;
		major = personMajor;
		yearOfGraduation = personYearOfGraduation;
	}

	/**
	 * Methods to get Student Attributes
	 */
	public double getGpa() {
		return gpa;
	}

	public String getMajor() {
		return major;
	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}

}
