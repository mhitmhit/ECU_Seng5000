/*<listing chapter="7" number="8">*/
package A5_Q3;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Hash table implementation using chaining.
 * @param <K> The key type
 * @param <V> The value type
 * @author Koffman and Wolfgang
 **/
public class HashtableChain<K, V> 
// Insert solution to programming project 7, chapter 07 here
    implements KWHashMap<K, V> {

    /** The table */
    private LinkedList<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 0.75;
    
    /*<listing chapter="7" number="3">*/
    // Note this is equivalent to java.util.AbstractMap.SimpleEntry
    /** Contains key-value pairs for a hash table. 
        @param <K> the key type
        @param <V> the value type
     */
    public static class Entry<K, V> 
// Insert solution to programming project 6, chapter 07 here
    {

        /** The key */
        private final K key;
        /** The value */
        private V value;

        /**
         * Creates a new key-value pair.
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         * @return The key
         */
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         * @return The value
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         * @param val The new value
         * @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

// Insert solution to programming exercise 4, section 4, chapter 07 here
    }
    /*</listing>*/

    // Constructor
    @SuppressWarnings({"unchecked", "rawtypes"})
    public HashtableChain() {
        table = new LinkedList[CAPACITY];
    }
    
    // Constructor for test purposes
    @SuppressWarnings({"unchecked", "rawtypes"})
    HashtableChain(int capacity) {
        table = new LinkedList[capacity];
    }

    /*<listing chapter="7" number="9">*/
    /**
     * Method get for class HashtableChain.
     * @param key The key being sought
     * @return The value associated with this key if found;
     *         otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null; // key is not in the table.
        }
        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.getKey().equals(key)) {
                return nextItem.getValue();
            }
        }

        // assert: key is not in the table.
        return null;
    }
    /*</listing>*/
    
    /*<listing chapter="7" number="10">*/
    /**
     * Method put for class HashtableChain.
     * postThis key-value pair is inserted in the
     *       table and numKeys is incremented. If the key is already
     *       in the table, its value is changed to the argument
     *       value and numKeys is not changed.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if
     *         found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<>();
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.getKey().equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.getValue();
                nextItem.setValue(value);
                return oldVal;
            }
        }

        // assert: key is not in the table, add new item.
        table[index].addFirst(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) {
            rehash();
        }
        return null;
    }
    /*</listing>*/

// Insert solution to programming exercise 4, section 4, chapter 07 here

// Insert solution to programming exercise 5, section 4, chapter 07 here

    /** Returns true if empty 
        @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }
// ----------------------------------------------------------------------------------------------Added by Yassine
    /** The number of DELETED */
    private int numDeletes=0;
    private V DELETED = (V) "DELETED";
   
    /**
     * Remove method to set removed items values to DELETED
     * 
     * @param Key of item to be removed
     * @return return V item of removed item or null if not in the table
     */
	@Override
	public V remove(Object key) {
		int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        V removedValue = null;
        if (table[index] == null) {
            return null; // key is not in the table.
        }
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.getKey().equals(key)) {
                removedValue = nextItem.getValue();
                put(nextItem.getKey(), DELETED);
                numDeletes++;
                numKeys--;     
                return removedValue;
            }
        }
		return removedValue;
	}
	
	/**
	 * Rehash method.
	 * created a new Table with double size of oldTable
	 * iterates through old table and uses put method to 
	 * put item into new Table
	 * 
	 */
	@SuppressWarnings({"unchecked"})
	public void rehash() {
		LinkedList<Entry<K, V>>[] oldTable = table;
		table = new LinkedList[2*CAPACITY +1];
		numKeys = 0;
		numDeletes = 0;
		for (LinkedList<Entry<K, V>> entry : oldTable) {
            while (entry != null) {
            	for (int i = 0; i< entry.size(); i++) {
            		if(entry.get(i).getValue()!="DELETED") {
	                	put(entry.get(i).getKey(), entry.get(i).getValue());
	                	numKeys++;
            		};
            	}
            }
        }
	}
	 // ---------------------------------------------------------------------------------------------End Added by Yassine  
// Insert solution to programming exercise 2, section 4, chapter 07 here


// Insert solution to programming project 7, chapter 07 here
}
/*</listing>*/
