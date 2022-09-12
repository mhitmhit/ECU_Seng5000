package chapter06_Exercises;

public class SumSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int product = 0;
//	      
//	      for (int x = 1; x <= 100; x++)
//	      {
//	         product = product + (x*x);
//	      }
//	      // Output the result
//	      System.out.println("The product is:: " + product);
//		
		int sum = 0;
	      // The sum of all squares between 1 and 100
	      for (int x = 1; x <= 100; x++)
	      {
	         sum = sum + x * x;
	      }
	      // Output the result
	      System.out.println("The sum is " + sum);
	}
}
