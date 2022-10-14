package A3_Q3;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseTheWordsInLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		String inputLine = in.nextLine();
		
		ArrayList<String> inputArray = new ArrayList<String>();

		for (String word : inputLine.split(" ")) {
			inputArray.add(0, word);
		}
		
		
		
		System.out.println("the input line is: " + inputLine);
		System.out.println(inputArray.toString());
	}

}
