package KW.CH03;

/**
 *
 * @author Koffman & Wolfgang
 */
public class Exercies {

    /**
     * Search an array for a target value.
     *
     * @param theArray The array to be searched
     * @param target The value sought
     * @param start The start index for the search
     * @param end The end index for the search
     * @return index of the target or end if not found.
     * @throws IllegalArgumentException if end <= start
     * @
     * throws ArrayIndexOutOfBounds if start or end is not in the array
     */
    public static int search(int[] theArray, int target, int start, int end) {
        if (end <= start) {
            throw new IllegalArgumentException("Null search range start: " 
                    + start + " end: " + end);
        }
        for (int i = start; i < end; i++) {
            if (target == theArray[i]) {
                return i;
            }
        }
        return end;
    }
    
    /**
     * Driver for readInt
     */
    public static void driverForReadInt() {
        System.out.println("\nVerify that the prompt says \"Enter weight\" "
                + "\nEnter an integer between 2 and 5\"");
        System.out.println("Enter a non-numeric value and verify that the message"
                + "\"Bad numbric string - Try again\" is displayed"
                + "followed by the prompt");
        System.out.println("Then enter a zero and verify that the prompt is rpeated");
        System.out.println("Then entar a 7 and verify that the prompt is repeated");
        System.out.println("Finally enter a 3");
        int result = MyInput.readInt("Enter weight", 2, 5);
        System.out.println("The value entered was " + result);
        try {
            MyInput.readInt("", 5, 2);
            System.out.println("Exception was not thrown");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception was thrown as expected");
        }
    }

    /**
     * Stub to use in place of readInt
     */
    public static int readInt(String prompt, int minN, int maxN) {
        return 5;
    }
    
    /**
     * Driver program to test search method
     */
    public static void testSearch() {
        int[] testArray = {1, 2, 4, 5, 3, 9};
        int result;
        result = search(testArray, 4, 0, 6);
        System.out.println("Test passed " + (result == 2 ? "Yes" : "NO!"));
        result = search(testArray, 4, 1, 5);
        System.out.println("Test passed " + (result == 2 ? "Yes" : "NO!"));
        result = search(testArray, 10, 0, 6);
        System.out.println("Test passed " + (result == 6 ? "Yes" : "NO!"));
        result = search(testArray, 2, 1, 5);
        System.out.println("Test passed " + (result == 1 ? "Yes" : "NO!"));
        result = search(testArray, 3, 2, 5);
        System.out.println("Test passed " + (result == 4 ? "Yes" : "NO!"));
        try {
            result = search(testArray, 3, 5, 2);
            System.out.println("Exception was not thrown");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception was thown as expected");
        }       
    }
  
    
    /** Finds the largest value in array elements x[start] through x[last].
     * @param x array whose largest value is found
     * @param start first subscript in range
     * @param last last subscript in range
     * @return the largest value of x[start] through x[last]
     * @pre first <= last
     */
    public static int findMax(int[] x, int start, int last) {
        if (start > last)
            throw new IllegalArgumentException("Empty range");
        int maxSoFar = 0;
        for (int i = start; i < last; i++) {
            System.out.printf("i: %d maxSoFar: %d x[%d]: %d %n", i, maxSoFar, i, x[i]);
            if (x[i] > maxSoFar)
                maxSoFar = i;
        }
        return maxSoFar;
    }
    
    
}
