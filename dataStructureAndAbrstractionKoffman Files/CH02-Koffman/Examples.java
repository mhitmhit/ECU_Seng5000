package KW.CH02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Class to contain example methods in Chapter 2
 *
 * @author Koffman and Wolfgang
 */
public class Examples {

    /**
     * Searches an array to find the first occurrence of a target.
     *
     * @param x Array to search
     * @param target Target to search for
     * @return The subscript of first occurrence if found; otherwise, return -1.
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

    /*<example chapter="2" number="2">

     /** Determine whether two arrays have no common elements.
     @param x One array
     @param y The other array
     @return true if there are no common elements
     */
    public static boolean areDifferent(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            if (search(y, x[i]) != -1) {
                return false;
            }
        }
        return true;
    }
    /*</example>*/

    /*<example chapter="2" number="3">*/
    /**
     * Determine whether the contents of an array are all unique.
     *
     * @param x The array
     * @return true if all elements of x are unique
     */
    public static boolean areUnique(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (i != j && x[i] == x[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    /*</example>*/

    /*<example chapter="2" number="4">*/
    /**
     * Determine whether the contents of an array are all unique.
     *
     * @param x The array
     * @return true if all elements of x are unique
     */
    public static boolean areUnique2(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    /*</example>*/

    /*<example chapter="2" number="11">*/
    /**
     * Remove the items divisible by div.
     *
     * @param aList The list items are removed from.
     * @param div The divisor.
     * preinkedList aList contains Integer objects.
     * postElements divisible by div have been removed.
     */
    public static void removeDivisibleBy(LinkedList<Integer> aList, int div) {
        Iterator<Integer> iter = aList.iterator();
        while (iter.hasNext()) {
            int nextInt = iter.next();
            if (nextInt % div == 0) {
                iter.remove();
            }
        }
    }
    /*</example>*/
    
    /*<example chapter="2" number="13">*/
    /**
     * Searches for target in list myList and if target is present, replaces
     * its first occurrence with newItem.
     * 
     * @param myList The list to be searched
     * @param target The target value to be found
     * @param newItem The new item to replace targer
     */
    public static void replaceItem(List<String> myList, String target, String newItem) {
        ListIterator<String> myIter = myList.listIterator();
        while (myIter.hasNext()) {
            if (target.equals(myIter.next())) {
                myIter.set(newItem);
                break;  // Exit loop
            }
        }
    }
    /*</example>*/
}
