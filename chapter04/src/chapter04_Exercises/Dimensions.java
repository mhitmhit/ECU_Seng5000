package chapter04_Exercises;

public class Dimensions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double inchToMilim = 25.4;
		double paperW = 8.5;
		double paperH = 11;
		
//		System.out.printf("paper size in mili: %4.2f", paperW*inchToMilim);
//		System.out.printf("x%4.2f", paperH*inchToMilim);
		System.out.printf("paper size in mili: %4.2f x %4.2f",paperW*inchToMilim,paperH*inchToMilim );
	}

}
