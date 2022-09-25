package chapter11_Exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class exercise_11_1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// chapter 11 Exercises Directory Path:
		// D:\Documents\SCHOOL\ECU SENG 5000 Prog and Data Structures\SENG5000_Eclipse\ECU_Seng5000\chapter11\src\chapter11_Exercises
		final String path = "D:\\Documents\\SCHOOL\\ECU SENG 5000 Prog and Data Structures\\SENG5000_Eclipse\\ECU_Seng5000\\chapter11\\src\\chapter11_Exercises\\";
		
		// read content of the file
		PrintWriter out = new PrintWriter(path + "hello.txt");
		out.println("Hello, World!!");
		out.close();
		
		// read content from file and dispaly it in console
		File inputFile = new File(path + "hello.txt");
		Scanner in = new Scanner(inputFile);
		String message = in.nextLine();
		System.out.println(message);
		in.close();
	}
}
