package chapter05_Exercises;

import java.util.Scanner;

public class HowManyDigitsNumberHas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter a number");
		int num = in.nextInt();
		int digits=0;
		if(num<0) {num = -1* num;}
		
		if (num >=10000) {digits = 5;}
		else if (num>= 1000){digits = 4;}
		else if (num>= 100){digits = 3;}
		else if (num>= 10){digits = 2;}
		else if (num>= 0){digits = 1;}
		
		System.out.println("number of digits is: " + digits);
	}

}
