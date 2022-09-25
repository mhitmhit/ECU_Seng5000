package chapter11_Exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class exercise_11_3 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// chapter 11 Exercises Directory Path:
		// D:\Documents\SCHOOL\ECU SENG 5000 Prog and Data Structures\SENG5000_Eclipse\ECU_Seng5000\chapter11\src\chapter11_Exercises
		final String path = "D:\\Documents\\SCHOOL\\ECU SENG 5000 Prog and Data Structures\\SENG5000_Eclipse\\ECU_Seng5000\\chapter11\\src\\chapter11_Exercises\\";
		
		// ask user to enter file name
		System.out.println("enter the file name you want to read from: ");
		Scanner in = new Scanner(System.in);
		String providedFileName = in.next();
		in.close();
		
		// read content of the file
		PrintWriter out = new PrintWriter(path + providedFileName);
		out.println("Hello, World!! this is exercise 3 from chapter 11");
		out.close();
		
		// read content from file and dispaly it in console
		File inputFile = new File(path + providedFileName);
		in = new Scanner(inputFile);
		String message = in.nextLine();
		System.out.println(message);
		in.close();
	}
}
