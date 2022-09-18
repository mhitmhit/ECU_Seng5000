package A2_Q5;

public class Person {
	/**
	 * Attributes common to all persons
	 */
	private String name;
	private int socialSecurityNumber;
	private int age;
	private char gender;
	private String address;
	private int telephone;
	/**
	 * Constructor for person
	 * 
	 * @param personName
	 * @param personSocialSecurityNumber
	 * @param personAge
	 * @param personGender
	 * @param personAddress
	 * @param personTelephone
	 */
	public Person(String personName, int personSocialSecurityNumber, int personAge, char personGender, String personAddress, int personTelephone){
		name = personName;
		socialSecurityNumber = personSocialSecurityNumber;
		age = personAge;
		gender = personGender;
		address = personAddress;
		telephone = personTelephone;
	}
	
	/**
	 * methods to get Person attributes
	 */
	public String getName() {
		return name;
	}
	
	public int getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getTelephone() {
		return telephone;
	}

}
