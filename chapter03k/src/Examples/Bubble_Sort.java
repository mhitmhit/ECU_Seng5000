package Examples;

import java.util.ArrayList;

public class Bubble_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(6);
		numbers.add(3);
		numbers.add(5);
		numbers.add(4);
		numbers.add(1);
		numbers.add(2);
		
		System.out.println("before bubble sort: " + numbers);	
		
		int i = 0;
		int j = 0;
		
		for (i = 0; i < numbers.size()-1; i++) {
			for (j = 0; j < numbers.size()-1; j++) {
				if (numbers.get(j) > numbers.get(j+1)) {
					int temp = numbers.get(j);
					numbers.set(j, numbers.get(j+1));
					numbers.set(j+1, temp);
					System.out.println("inside j loop                "  + numbers);
				}
			}
		}
		
		System.out.println("after bubble sort: " + numbers);
		
	}

}
