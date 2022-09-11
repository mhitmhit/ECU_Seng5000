package chapter04_Exercises;

import java.util.Scanner;

public class AddCommaToUserInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number you want to process");
		String num = in.next();
		
		
		String SecondPart = num.substring(num.length()-3,num.length());
		String firstPart = num.substring(0,num.length()-3);
		System.out.println("the result is: "+firstPart+","+SecondPart);
		
		
	}

}
