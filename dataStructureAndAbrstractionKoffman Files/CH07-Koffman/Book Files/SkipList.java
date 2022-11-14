package KW.CH07;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

public class SkipList<K extends Comparable<K>, V> {

    /**
     * Contains key-value pairs for a hash table.
     */
    private static class Entry<K, V> {

        /**
         * The key
         */
        private final K key;
        /**
         * The value
         */
        private V value;

        /**
         * Creates a new key-value pair.
         *
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         *
         * @return The key
         */
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         *
         * @return The value
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         *
         * @param val The new value
         * @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

// Insert solution to programming exercise 1, section 8, chapter 07 here

    }

    /**
     * Static class to contain the data and the links
     */
    private static class SLNode<K, V> {

        private SLNode<K, V>[] links;
        private Entry<K, V> item;

        /**
         * Create a node of level m
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        public SLNode(int m, Entry<K, V> item) {
            this.item = item;
            links = (SLNode<K, V>[]) new SLNode[m]; // create links
        }

        /**
         * Create a node of level m
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        public SLNode(int m, K key, V value) {
            item = new Entry<>(key, value);
            this.links = (SLNode<K, V>[]) new SLNode[m]; // create links
        }

// Insert solution to programming exercise 1, section 8, chapter 07 here

    }

    /**
     * The current size of the skipList
     */
    private int size;
    /**
     * Maximum level
     */
    private int maxLevel;
    /**
     * Nominal maximum capacity
     */
    private int maxCap;
    /**
     * The head node is a dummy node, it contains no data
     */
    private SLNode<K, V> head;
    //Array to hold list of predecessors during a search
    // private final SLNode<K> pred;

    /**
     * Construct an initially empty SkipList.
     */
    public SkipList() {
        size = 0;
        maxLevel = 1;
        maxCap = 1;
        head = new SLNode<>(maxLevel, null, null);
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

// Insert solution to programming exercise 1, section 8, chapter 07 here

    @SuppressWarnings({"unchecked", "rawtypes"})
    /**
     * Search for an item in the list
     *
     * @param item The item being sought
     * @return A SLNode array which references the predecessors of the target at
     * each level.
     */
    private SLNode<K, V>[] search(K target) {
        var pred = (SLNode<K, V>[]) new SLNode[maxLevel];
        var current = head;
        for (int i = current.links.length - 1; i >= 0; i--) {
            while (current.links[i] != null
                    && current.links[i].item.key.compareTo(target) < 0) {
                current = current.links[i];
            }
            pred[i] = current;
        }
        return pred;
    }

    /**
     * Find an object in the skip-list
     *
     * @param target The item being sought
     * @return A reference to the object in the skip-list that matches the
     * target. If not found, null is returned.
     */
    @SuppressWarnings("unchecked")
    public V get(Object target) {
        K targ = (K) target;
        var pred = search(targ);
        if (pred[0].links[0] != null
                && pred[0].links[0].item.key.compareTo(targ) == 0) {
            return pred[0].links[0].item.value;
        } else {
            return null;
        }
    }

    /**
     * Natural Log of 2
     */
    static final double LOG2 = Math.log(2.0);
    /**
     * A random number generator
     */
    private final Random RAND = new Random();

    /**
     * Method to generate a logarithmic distributed integer between 1 and
     * maxLevel. i.e., 1/2 of the values returned are 1, 1/4 are 2, 1/8 are 3,
     * etc.
     *
     * @return a random logarithmic distributed int between 1 and maxLevel
     */
    private int logRandom() {
        //Random rAND = new Random();
        int r = RAND.nextInt(maxCap);
        int k = (int) (Math.log(r + 1) / LOG2);
        if (k > maxLevel - 1) {
            k = maxLevel - 1;
        }
        return maxLevel - k;
    }

    private int computeMaxCap(int n) {
        return (1 << n) - 1;
    }

    public V put(K target, V value) {
        // Array of predecessors found during search
        // var pred = new SLNode<K> [];
        // var pred = (SLNode<K>[]) new SLNode[maxLevel];

        // variable to hold result of search
        var pred = search(target);
        if (pred[0].links[0] != null
                && pred[0].links[0].item.key.compareTo(target) == 0) {
            return pred[0].links[0].item.setValue(value);
        } else {
            // Declare local variables
            SLNode<K, V> newNode; // new node to be inserted
            int levelNewNode;     // level of new node
            // The target key was not found, insert it in the skip-list
            // Increment size and check for full skip-list
            size++;
            if (size > maxCap) {
                // Skip-list is full - update skip-list data fields
                maxLevel++;
                maxCap = computeMaxCap(maxLevel);
                head.links = Arrays.copyOf(head.links, maxLevel);
                pred = Arrays.copyOf(pred, maxLevel);
                pred[maxLevel - 1] = head;
                levelNewNode = maxLevel;
            } else {
                levelNewNode = logRandom();
            }
            // Create a new skip-list node for item
            newNode = new SLNode<>(levelNewNode, target, value);
            // Splice it into the skip-list
            for (int i = 0; i < levelNewNode; i++) {
                newNode.links[i] = pred[i].links[i];
                pred[i].links[i] = newNode;
            }
            return null;  // new node inserted
        }  // end if-else
    }   // end put
    
// Insert solution to programming project 11, chapter 07 here
    
// Insert solution to programming exercise 3, section 8, chapter 07 here

}
