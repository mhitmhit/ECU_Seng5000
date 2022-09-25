package chapter11_Exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exercise_11_5 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// chapter 11 Exercises Directory Path:
		// D:\Documents\SCHOOL\ECU SENG 5000 Prog and Data Structures\SENG5000_Eclipse\ECU_Seng5000\chapter11\src\chapter11_Exercises
		final String path = "D:\\Documents\\SCHOOL\\ECU SENG 5000 Prog and Data Structures\\SENG5000_Eclipse\\ECU_Seng5000\\chapter11\\src\\chapter11_Exercises\\";
		int count = 0;

		// ask user to enter file name
		System.out.println("enter the file name you want to read from: ");
		Scanner in = new Scanner(System.in);
		String providedFileName = in.next();
		in.close();
		
		// read content from file
		File inputFile = new File(path + providedFileName);
		in = new Scanner(inputFile);
		
		// count how many lines in the file
		while (in.hasNextLine()) {
			in.nextLine();
			count ++;
		}
		System.out.println("this document has a line count of: " + count);
		in.close();
		
		// count how many words in the file
		count = 0;
		in = new Scanner(inputFile);
		while (in.hasNext()) {
			in.next();
			count ++;
		}
		System.out.println("this document has a word count of: " + count);
		in.close();
		
		// count how many char in the file
		count = 0;
		char value;
		in = new Scanner(inputFile);
		in.useDelimiter("");
		while (in.hasNext()) {
			value = in.next().charAt(0);
			if (!Character.isWhitespace(value)) {
				count ++;
			}
		}
		System.out.println("this document has a char count of: " + count);
		in.close();
		
		
		
	}
}
