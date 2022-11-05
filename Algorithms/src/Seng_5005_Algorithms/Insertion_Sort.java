package Seng_5005_Algorithms;

import java.util.ArrayList;

public class Insertion_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(6);
		numbers.add(3);
		numbers.add(5);
		numbers.add(4);
		numbers.add(1);
		numbers.add(2);
		
		System.out.println("before insertion sort: " + numbers);
		
		int  i = 0;
		int j = 0;
		int temp = 0;
		
		for ( j = 1; j < numbers.size(); j++) {
			i = 0;
			temp = numbers.get(j);
			while ( i <= j-1) {
					if (temp < numbers.get(i)) {
						numbers.remove(j);
						numbers.add(i, temp);
						break;
					}
					i++;
			}			
		}
		
		System.out.println("after inserton sort: " + numbers);
	}

}
