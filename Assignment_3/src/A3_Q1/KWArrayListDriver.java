package A3_Q1;

public class KWArrayListDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KWArrayList<String> myArray = new KWArrayList<String>();
		
		// adding values to array
		myArray.add(0, "test 0");
		myArray.add(1, "test 1");
		myArray.add(2, "test 2");
		myArray.add(3, "test 3");
		myArray.add(4, "test 4");
		myArray.add(5, "test 5");
		myArray.add(6, "test 6");
		myArray.add(7, "test 7");
		myArray.add(8, "test 8");
		myArray.add(9, "test 9");
		
		// testing array values are storred as expected
		System.out.println("storred value at index 4 is: " + myArray.get(4));
		
		// testing indexOf method,
		System.out.println("item found at position: " + myArray.indexOf("test 10")); // returns -1
		System.out.println("item found at position: " + myArray.indexOf("test 1")); // returns 1
		System.out.println("item found at position: " + myArray.indexOf("test 18")); // returns -1
		System.out.println("item found at position: " + myArray.indexOf("test 7")); // returns 7
		
		
	}

}
