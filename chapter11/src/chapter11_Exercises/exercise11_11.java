package chapter11_Exercises;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class exercise11_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> inputNumbers = new ArrayList<Double>();
		double sum = 0;
		int errorCount = 0;
		//String value = promptToEnterNumbers();
		System.out.println("enter a set of floating numbers : ");
		Scanner in = new Scanner(System.in);
		
		double value;
		while (errorCount < 2) {
			try {
				value = in.nextDouble();
				System.out.println("last value added is " + value);
				inputNumbers.add(value);
			}catch(InputMismatchException e) {
				System.out.println("the value you entered was not a float, please try again");
				in.next();
				errorCount ++;
			}
		}
		
		for (double ele : inputNumbers) {
			sum = sum + ele;
		}
		System.out.println("the values entered are: ");
		System.out.println(inputNumbers);
		System.out.println("the sum is: " + sum);
		
		
		in.close();
	}

}
