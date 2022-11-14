/*<listing chapter="7" section="5">*/
package KW.CH07;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringJoiner;

/**
 * A hash set for storing set elements using open addressing. This version
 * is an adapter of a HashMap and extends the AbstractMap.
 * @param <K> The key type
 * @author Koffman and Wolfgang
 **/
public class HashSetOpen<K> extends AbstractSet<K> {

    private final Map<K, K> setMap = new HashtableOpen<>();

    /**
     * Adapter method contains.
     * @param key The key being sought
     * @return true if the key is found in setMap
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object key) {
        // HashtableOpen.get returns null if the key is not found.
        return (setMap.get((K)key) != null);
    }

    /**
     * Adapter method add.
     * postAdds a new Entry object (key, key)
     * if key is not a duplicate.
     * @param key The key being inserted
     * @return true if the key is not a duplicate
     */
    @Override
    public boolean add(K key) {
        /* HashtableOpen.put returns null if the
        key is not a duplicate. */
        return (setMap.put(key, key) == null);
    }

    /**
     * Adapter method remove.
     * post: Removes the key-value pair (key, key).
     * @param key The key being removed
     * @return true if the key is found and removed
     */
    @Override
    public boolean remove(Object key) {
        // HashtableOpen.remove returns null if the
        // key is not removed. */
        return (setMap.remove(key) != null);
    }

    /**
     * Adapter method size.
     * @return the size of the set
     */
    @Override
    public int size() {
        return setMap.size();
    }

// Insert solution to programming project 8, chapter 07 here

// Insert solution to programming exercise 2, section 1, chapter 07 here
}
