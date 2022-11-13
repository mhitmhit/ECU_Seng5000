package KW.CH06;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to demonstrate Set operations
 * @author Koffman &amp; Wolfgang
 */
public class SetOperations {
    
    /**
     * Union contains all of the elements in both sets;
     * @param <T> The type of the set contents.
     * @param setA one set
     * @param setB the other set
     * @return A set that contains elements that appear in either setA or setB
     */
    public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> result = new HashSet<>(setA);
        result.addAll(setB);
        return result;
    }
    
    /**
     * Union contains the elements that are common both sets;
     * @param <T> The type of the set contents.
     * @param setA one set
     * @param setB the other set
     * @return A set that contains elements that appear both in setA and setB
     */
    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> result = new HashSet<>(setA);
        result.retainAll(setB);
        return result;
    }
    
    
    /**
     * Union contains the elements that are one set but not in both.
     * @param <T> The type of the set contents.
     * @param setA one set
     * @param setB the other set
     * @return A set that contains elements that appear in setA but not in setB
     */
    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> result = new HashSet<>(setA);
        result.removeAll(setB);
        return result;
    }
}
