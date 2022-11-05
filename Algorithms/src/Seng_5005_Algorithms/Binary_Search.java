package Seng_5005_Algorithms;

import java.util.ArrayList;

public class Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(0);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		
		System.out.println("before Binary search: " + numbers);	
		
		
		int i = 0;
		int j = numbers.size()-1;
		
		int x = 6;
		int location = -1;
		
		while( i < j) {
			int m = (i+j)/2;
			if( x > numbers.get(m)){
				i = m + 1;
			}else{
				j = m;
			}
		}
		if( x == numbers.get(i)) {
			location = i;
		}
		
		System.out.println("index location of the item is: " + location);
		
		
		
		

	}

}
