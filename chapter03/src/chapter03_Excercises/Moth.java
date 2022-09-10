package chapter03_Excercises;

public class Moth {
	
	private double initialPosition;
	private double currentPosition;
	
	public Moth(double initialPosition) {
		
		this.initialPosition = initialPosition;
		currentPosition = initialPosition;
	}
	
	public void moveToLight(double lightPosition) {
		currentPosition = (initialPosition + lightPosition)/2;
	}
	
	public double getPosition() {
		return currentPosition;
	}
}
