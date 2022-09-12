package chapter06_Exercises;

import java.util.Scanner;

public class PrintsAllSubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("enter a string");
		String userInput = in.next();
		
		for (int j=1; j<=userInput.length();j++) {
			
			for (int i=0; i<userInput.length(); i++) {
				String value = userInput.substring(i, j);
				System.out.println(value);
			}
			
		}
	}

}
