package chapter05_Exercises;

import java.util.Scanner;

public class NegativePositiveOrZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter a number");
		int num = in.nextInt();
		
		if(num==0) {
			System.out.println("number equals is zero !!");
		}else if(num<0) {
			System.out.println("number is negative");
		}else {
			System.out.println("number is positive");
		}
	}

}
