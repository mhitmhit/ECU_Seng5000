package chapter06_Exercises;

import java.util.Scanner;

public class TakeFloatingAndReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter Float numbers");
		float userInput = in.nextFloat();
		float userInput2 = in.nextFloat();
		float userInput3 = in.nextFloat();
		
		
		System.out.println();
		
		System.out.println(userInput + userInput2 + userInput3);
	}

}
