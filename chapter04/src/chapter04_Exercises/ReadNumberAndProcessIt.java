package chapter04_Exercises;

import java.util.Scanner;

public class ReadNumberAndProcessIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter a number:");
		double num = in.nextDouble();
		
		System.out.println("the number you entered is: " + num);
		System.out.println("the square of the number is: "+ num*num);
		System.out.println("the cube of the number is: " + num*num*num);
		System.out.println("the fourth power of the number is: " + Math.pow(num, 4));
	}

}
