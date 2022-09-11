package chapter04_Exercises;

import java.util.Scanner;

public class FlieNamePrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String drive;
		String path;
		String fileName;
		String extension;
		
		Scanner in = new Scanner(System.in);
		System.out.println("enter the drive name: ");
		drive = in.next();
		System.out.println("enter the path: ");
		path = in.next();
		System.out.println("enter the file name: ");
		fileName = in.next();
		System.out.println("enter the extension: ");
		extension = in.next();
		
		System.out.println(drive+":\\"+path+"\\"+fileName+extension);
		
	}

}
