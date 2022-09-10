package chapter03_Excercises;

public class SavingsAccountTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SavingsAccount SavAccount1 = new SavingsAccount(1000, 10);
		System.out.println("account balance before interest applied: "  + SavAccount1.getBalance());
		SavAccount1.addInterest();
		System.out.println("account balance after interest applied: "  + SavAccount1.getBalance());
	}

}
