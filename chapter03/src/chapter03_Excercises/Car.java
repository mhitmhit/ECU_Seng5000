package chapter03_Excercises;

public class Car {

	private double mileage;
	private double gasInTank;

	public Car(double efficiency) {
		mileage = efficiency;
		gasInTank = 0;
	}
	
	public void addGas(double gas) {
		gasInTank = gasInTank + gas;
	}
	
	public void drive(double miles) {
		gasInTank = gasInTank - (miles / mileage);
	}
	
	public double getGasInTank() {
		return gasInTank;
	}
	
	
}
