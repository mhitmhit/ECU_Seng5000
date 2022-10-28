package A4_Q4;

public class Recursive_Linear_Search {
	
	/**
	 * Recursive linear search to search for last
	 * item in an array of Objects.
	 * method starts with last index in the array, 
	 * and feeds [last index -1] to recursion.
	 * base case is when lastPos = -1.
	 * @param items
	 * @param target
	 * @param lastPos
	 * @return
	 */
	private static int linearSearch(Object[] items, Object target, int lastPos) {
        if (lastPos == -1) {
            return -1;
        } else if (target.equals(items[lastPos])) {
            return lastPos;
        } else {
            return linearSearch(items, target, lastPos - 1);
        }
    }

    /**
     * Wrapper for recursive linear search method (in
     * RecursiveMethods.java).
     * @param items The array being searched
     * @param target The object being searched for
     * @return The subscript of target if found; otherwise -1
     */
    public static int linearSearch(Object[] items, Object target) {
        return linearSearch(items, target, items.length-1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] myArray = {2, 1, 1, 1, 1, 1};
		Integer[] myArray2 = {};
		
		// testing of recursive search of last item
		System.out.println(linearSearch(myArray, 2)); // expecting 0
		System.out.println(linearSearch(myArray, 5)); // expecting -1
		System.out.println(linearSearch(myArray, 1)); // expecting 5
		
		// testing of an empty array
		System.out.println(linearSearch(myArray2, 1)); // expecting -1 
		
		
		
	}

}
