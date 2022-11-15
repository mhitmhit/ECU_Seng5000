package q3Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Hash table implementation using chaining.
 * @param <K> The key type
 * @param <V> The value type
 * @author Koffman and Wolfgang
 */
public class HashtableChain<K, V> implements KWHashMap<K, V> {
    // Data Fields
	/** The table */
	private LinkedList<Entry<K, V>>[] table;
	/** The number of keys */
	private int numKeys;
	/** The capacity */
	private static final int CAPACITY = 101;
	/** The maximum load factor */
	private static final double LOAD_THRESHOLD = 3.0;
	// Note this is equivalent to java.util.AbstractMap.SimpleEntry
    /** Contains key-value pairs for a hash table. 
        @param <K> the key type
        @param <V> the value type
     */
    public static class Entry<K, V> implements Map.Entry<K, V> {

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
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         * @return The value
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         * @param val The new value
         * @return The old value
         */
        @Override
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        /**
         * Return a String representation of the Entry
         * @return a String representation of the Entry
         *         in the form key = value
         */
        @Override
        public String toString() {
            return key.toString() + "=" + value.toString();
        }
    }

    // Constructor
    public HashtableChain() {
        table = new LinkedList[CAPACITY];
    }
    
    // Constructor for test purposes
    HashtableChain(int capacity) {
        table = new LinkedList[capacity];
    }

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

    /**
     * Method put for class HashtableChain.
     * @post This key-value pair is inserted in the
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
 
    /** Returns the number of entries in the map 
        @return the number of entries in the map
     */
    @Override
    public int size() {
        return numKeys;
    }


    /** Returns true if empty 
        @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    
    /** 
     * Method rehash for class HashtableChain.
     * @post Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * 		 the size of table is doubled and is an
     *       odd integer. Each non-deleted entry from the original
     *       table is reinserted into the expanded table.
     *       The value of numKeys is reset to the number of items
     *       actually inserted; numDeletes is reset to 0.
     * @param key: The key of item being inserted
     * @param value: The value for this key
     * @param oldtable: original table
     * @param table: saves reference to oldtable
     * @return Non-deleted entry from old table is now in this table. This creates a smaller list.
     */
    public void rehash() {
        // Save a reference to oldTable
        LinkedList<Entry<K, V>>[] oldTable = table;
        // Double capacity of this table
        table = new LinkedList[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        for (LinkedList<Entry<K,V>> list : oldTable) {
            if (list != null) {
                for (Entry<K,V> entry : list) {
                	put(entry.getKey(), entry.getValue());
                	numKeys++;
                }
            }
        }
    }
    
    /**
     * Method remove for class HashtableChain.
     * @post STILL NEED TO FILL THIS OUT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *      STILL NEED TO FILL THIS OUT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *      STILL NEED TO FILL THIS OUT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *       STILL NEED TO FILL THIS OUT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * @param key The key of item being inserted
     * @param value The value for this key
     * @param index List of Values???
     * @param entry Item on the List???
     * @return 
     *         
     */
    public V remove(Object key) {
    	int index = key.hashCode() % table.length;
    	if (index < 0) {
    		index += table.length;
    	}
    	if (table[index] == null) {
    		return null; //key is not in table
    	}
    	for (Entry<K, V> entry : table[index]) {
    		if (entry.getKey().equals(key)) {
    			V value = entry.getValue();
    			table[index].remove(entry);
    			numKeys--;
    			if (table[index].isEmpty()) {
    				table[index] = null;
    			}
    			return value;
    		}
    	}
    	return null;
    }
    
   @Override
    public java.util.Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    /** Inner class to implement the set view. */
    private class EntrySet
            extends java.util.AbstractSet<Map.Entry<K, V>> {

        /** Return the size of the set. */
        @Override
        public int size() {
            return numKeys;
        }

        /** Return an iterator over the set. */
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new SetIterator();
        }
    }

    private class SetIterator implements Iterator<Map.Entry<K, V>> {

        int index = 0;
        Iterator<Entry<K, V>> localIterator = null;

        @Override
        public boolean hasNext() {
            if (localIterator != null) {
                if (localIterator.hasNext()) {
                    return true;
                } else {
                    localIterator = null;
                    index++;
                }
            }
            while (index < table.length
                    && table[index] == null) {
                index++;
            }
            if (index == table.length) {
                return false;
            }
            localIterator = table[index].iterator();
            return localIterator.hasNext();
        }

        @Override
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return localIterator.next();
        }

        @Override
        public void remove() {
            localIterator.remove();
            if (table[index].size() == 0) {
                table[index] = null;
            }
            numKeys--;
        }
    }
}