package chapter06_Exercises;

public class SumEvenNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int sum = 0;
//		for(int i=2; i<=100; i++) {
//			if (i%2==0) {
//				sum = sum + i;
//			}
//		}
//		System.out.println("sum of all numbers is: "+ sum);
		int sum = 0;
	      // The sum of all even numbers between 2 and 100
	      for (int x = 2; x <= 100; x = x + 2)
	      {
	         sum = sum + x;
	      }
	      // Output the result
	      System.out.println("The sum is:: " + sum);
		
		
	}
}
