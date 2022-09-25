package chapter11_Exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class exercise_11_7 {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// chapter 11 Exercises Directory Path:
		// D:\Documents\SCHOOL\ECU SENG 5000 Prog and Data Structures\SENG5000_Eclipse\ECU_Seng5000\chapter11\src\chapter11_Exercises
		final String path = "D:\\Documents\\SCHOOL\\ECU SENG 5000 Prog and Data Structures\\SENG5000_Eclipse\\ECU_Seng5000\\chapter11\\src\\chapter11_Exercises\\";
		ArrayList<String> dictionary = new ArrayList<String>();
		dictionary.add("java" );
		dictionary.add("python" );
		dictionary.add("c++" );
		dictionary.add("javascript" );
		dictionary.add("node" );
		
		ArrayList<String> inputWords = new ArrayList<String>();
		ArrayList<String> outputWords = new ArrayList<String>();
		
		File inputFile = new File(path + "test.txt");
		Scanner in = new Scanner(inputFile);
		
		// reads the words in the file and stores them into an arrayList
		while (in.hasNext()) {
			inputWords.add(in.next());
		}
		in.close();	
		
		for (String word : inputWords) {
			if (!inDictionary(word, dictionary)) {
				outputWords.add(word);
			}
		}
		
		System.out.println(outputWords);
		
	}
	
	// method to check if word in dictionary. 
	// returns true or false
	public static boolean inDictionary(String word, ArrayList<String> dictionary) {
		if (dictionary.indexOf(word) ==-1) {
			return false;
		}
		return true;
	}
	
}
	
	
