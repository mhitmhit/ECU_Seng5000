package KW.CH04;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Random;

/**
 * A randomized queue is similar to a queue, except that the item removed
 * is chosen at random from the items in the queue.
 * 
 * @param <E> The element type
 * @author Koffman &amp; Wolfgang
 **/
public class RandomizedQueue<E> extends AbstractQueue<E>
        implements Queue<E> {

    // Data Fields
    /** Index of the front of the queue. */
    private int front;
    /** Index of the rear of the queue. */
    private int rear;
    /** Current size of the queue. */
    private int size;
    /** Current capacity of the queue. */
    private int capacity;
    /** Default capacity of the queue. */
    private static final int DEFAULT_CAPACITY = 10;
    /** Array to hold the data. */
    private E[] theData;
    private Random rand;
    private int itemNumber;

    // Constructors
    /**
     * Construct a queue with the default initial capacity.
     */
    public RandomizedQueue() {
        this(DEFAULT_CAPACITY);
        rand = new Random();
        itemNumber = -1;
    }

    /**
     * Construct a queue with the specified initial capacity.
     * @param initCapacity The initial capacity
     */
    @SuppressWarnings("unchecked")
    public RandomizedQueue(int initCapacity) {
        capacity = initCapacity;
        theData = (E[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
        rand = new Random();
    }
    
    /**
     * Construct a queue with the contents of a Collection.The initial capacity 
     * is set to the size of the collection.
     * @param c Collection containing initial values.
     */
    public RandomizedQueue(Collection<E> c) {
        this(c.size());
        c.forEach(item -> offer(item));
    }

    // Public Methods
    /**
     * Inserts an item at the rear of the queue.
     * postitem is added to the rear of the queue.
     * @param item The element to add
     * @return true (always successful)
     */
    @Override
    public boolean offer(E item) {
        if (size == capacity) {
            reallocate();
        }
        size++;
        rear = (rear + 1) % capacity;
        theData[rear] = item;
        itemNumber = -1;
        return true;
    }
    
    /** Inserts an item at the front of the queue
     * post: item is added the front of the queue
     * @param item The element to add
     * @return true (always successful)
     */
    public boolean addFirst(E item) {
        if (size == capacity) {
            reallocate();
        }
        size++;
        front = (front - 1 + capacity) % capacity;
        theData[front] = item;
        itemNumber = -1;
        return true;
    }

// Insert solution to programming project 13, chapter 04 here

    /**
     * Return the size of the queue
     * @return The number of items in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator to the elements in the queue
     * @return an iterator to the elements in the queue
     */
    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    // Private Methods
    /**
     * Double the capacity and reallocate the data.
     * prehe array is filled to capacity.
     * postThe capacity is doubled and the first half of the
     *       expanded array is filled with data.
     */
    @SuppressWarnings("unchecked")
    private void reallocate() {
        int newCapacity = 2 * capacity;
        E[] newData = (E[]) new Object[newCapacity];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = theData[j];
            j = (j + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        theData = newData;
    }

    /** Inner class to implement the Iterator&lt;E&gt; interface. */
    private class Iter implements Iterator<E> {
        // Data Fields
        // Index of next element */

        private int index;
        // Count of elements accessed so far */
        private int count = 0;

        // Methods
        // Constructor
        /**
         * Initializes the Iter object to reference the
         * first queue element.
         */
        public Iter() {
            index = front;
        }

        /**
         * Returns true if there are more elements in the queue to access.
         * @return true if there are more elements in the queue to access.
         */
        @Override
        public boolean hasNext() {
            return count < size;
        }

        /**
         * Returns the next element in the queue.
         * prendex references the next element to access.
         * postindex and count are incremented.
         * @return The element with subscript index
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = theData[index];
            index = (index + 1) % capacity;
            count++;
            return returnValue;
        }

        /**
         * Remove the item accessed by the Iter objectd
         */
        @Override
        public void remove() {
            RandomizedQueue.this.removeAtIndex((index - 1 + capacity) % capacity);
        }
    }

// Insert solution to programming project 13, chapter 04 here
 
}
