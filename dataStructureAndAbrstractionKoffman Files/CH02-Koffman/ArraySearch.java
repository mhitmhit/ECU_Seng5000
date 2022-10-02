/*<listing chapter="2" number="2">*/
/**
 * Listing 2.2
 * @author Koffman and Wolfgang
 */
package KW.CH02;

/** Provides a static method search for searching an array. */
public class ArraySearch {

    /**
     * Searches an array to find the first occurrence of a target.
     * @param x Array to search
     * @param target Target to search for
     * @return The subscript of first occurrence if found;
     *         otherwise, return -1.
     */
    /*<example chapter="2" number="1">*/
    public static int search(int[] x, int target) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == target) {
                return i;
            }
        }
        // target not found
        return -1;
    }
    /*</example>*/

}
/*</listing>*/
