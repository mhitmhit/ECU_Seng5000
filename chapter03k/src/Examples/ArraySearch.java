package Examples;



/*<listing chapter="3" section="5" sequence="1">*/
/**
 * Provides a static method search that searches an array
 *
 * @author Koffman and Wolfgang
 */
public class ArraySearch {

    /**
     * Search an array to find the first occurrence of a target
     *
     * @param x Array to search
     * @param target Target to search for
     * @return The subscript of the first occurrence if found: 
     *         otherwise return -1
     * @throws NullPointerException if x is null
     */
    public static int search(int[] x, int target) {
        int index = 0;
        while (index < x.length) {
            if (x[index] == target) {
                return index; // target at index
            }
            index++;
        }
        return -1; // target not found
    }
    
}
    
/* &lt;/listing&gt; */
