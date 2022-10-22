/*<listing chapter="4" section="3">*/
// This listing was removed from the 3rd Edition
package KW.CH04;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/** Implementation of the interface StackInt using
 *  an array.
 *  @param <E> The type of elements
 *  @author Koffman and Wolfgang
 */
public class ArrayStack<E> implements StackInt<E> {

    // Data Fields
    /** Storage for stack. */
    E[] theData;
    /** Index to top of stack. */
    int topOfStack = -1; // Initially empty stack.
    private static final int INITIAL_CAPACITY = 10;

    /**
     * Construct an empty stack with the default
     * initial capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        theData = (E[]) new Object[INITIAL_CAPACITY];
    }

// Insert solution to programming project 5, chapter 04 here
    
    /**
     * Insert a new item on top of the stack.
     * postThe new item is the top item on the stack.
     *       All other items are one position lower.
     * @param obj The item to be inserted
     * @return The item that was inserted
     */
    @Override
    public E push(E obj) {
        if (topOfStack == theData.length - 1) {
            reallocate();
        }
        topOfStack++;
        theData[topOfStack] = obj;
        return obj;
    }

    /**
     * Remove and return the top item on the stack.
     * prehe stack is not empty.
     * postThe top item on the stack has been
     *       removed and the stack is one item smaller.
     * @return The top item on the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData[topOfStack--];
    }

    /**
     * Return the top item on the stack
     * Pre: The stack is not empty
     * Post: The stack remains unchanged
     * @return The top item on the stack
     * @throws NoSuchElementException If the stack
     *         is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData[topOfStack];
    }

    /**
     * Return true if the stack is empty
     * @return True if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return topOfStack == -1;
    }

    /**
     * Method to reallocate the array containing the stack data
     * postThe size of the data array has been doubled
     *       and all of the data has been copied to the new array
     */
    @SuppressWarnings("unchecked")
    private void reallocate() {
        E[] temp = (E[]) new Object[2 * theData.length];
        System.arraycopy(theData, 0, temp, 0, theData.length);
        theData = temp;
    }
    
// Insert solution to programming project 2, chapter 04 here
}
/*</listing>*/
