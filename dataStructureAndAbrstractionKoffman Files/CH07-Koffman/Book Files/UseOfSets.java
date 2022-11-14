/*<listing chapter="7" number="1">*/
/**
 * Listing 7.1
 *
 * @author Koffman &amp; Wolfgang
 */
package KW.CH07;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UseOfSets {

    public static void main(String[] args) {
        // Create the sets.
        Set<String> setA = new HashSet<>(List.of("Ann", "Sally", "Jill", "Sally"));
        Set<String> setAcopy = new HashSet<>(setA); // Copy of setA
        Set<String> setB = new HashSet<>(List.of("Bob", "Bill", "Ann", "Jill"));
        System.out.println("The 2 sets are: " + "\n" + setA
                + "\n" + setB);
        // Display the union and intersection.
        setA.addAll(setB); // Set union
        setAcopy.retainAll(setB); // Set intersection
        System.out.println("Items in set union are: " + setA);
        System.out.println("Items in set intersection are: "
                + setAcopy);
    }

// Insert solution to programming exercise 1, section 1, chapter 07 here
}
/*</listing>*/
