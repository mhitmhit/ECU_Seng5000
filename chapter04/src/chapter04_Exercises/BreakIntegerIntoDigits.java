package chapter04_Exercises;

import java.util.Scanner;

public class BreakIntegerIntoDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number you want to process");
		int num = in.nextInt();
		
		int firstDigit = num % 10;
		num = num/10;
		int secondDigit = num % 10;
		
		System.out.println(firstDigit +" " +secondDigit);
		
		System.out.printf("%d %d", secondDigit, firstDigit);
	}

}
