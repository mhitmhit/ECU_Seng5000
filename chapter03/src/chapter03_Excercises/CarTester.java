package chapter03_Excercises;

public class CarTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car(50);
		
		car1.addGas(20);
		car1.drive(100);
		
		System.out.println(car1.getGasInTank());
	}

}
