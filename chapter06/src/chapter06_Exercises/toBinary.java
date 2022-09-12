package chapter06_Exercises;

import java.util.Scanner;

public class toBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter a number");
		int num = in.nextInt();
		
		while(!(num==0)) {
			System.out.println(num%2);
			num = num/2;
		}
	}

}
