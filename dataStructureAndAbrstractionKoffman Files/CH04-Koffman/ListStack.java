/*<listing chapter="4" number="4">*/
package KW.CH04;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/** Class ListStack implements the interface StackInt as
 *  an adapter to the List. This implementation is functionally
 *  equivalent to that given in java.util.Stack except that the
 *  underlying List is not publicly exposed.
 *  @param <E> The type of the elements in the stack
 *  @author Koffman and Wolfgang
 */
public class ListStack<E> implements StackInt<E> {

    /** The List containing the data */
    private final List<E> theData;

    /**
     * Construct an empty stack using an ArrayList as the
     * container.
     */
    public ListStack() {
        theData = new ArrayList<>();
    }

    /**
     * Push an object onto the stack.
     * postThe object is at the top of the stack.
     * @param obj The object to be pushed
     * @return The object pushed
     */
    @Override
    public E push(E obj) {
        theData.add(obj);
        return obj;
    }

    /**
     * Peek at the top object on the stack.
     * @return The top object on the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData.get(theData.size() - 1);
    }

    /**
     * Pop the top object off the stack.
     * postThe object at the top of the stack is removed.
     * @return The top object, which is removed
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData.remove(theData.size() - 1);
    }

    /**
     * See whether the stack is empty.
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return theData.isEmpty();
    }
    
// Insert solution to programming exercise 2, section 3, chapter 04 here
            
// Insert solution to programming project 7, chapter 04 here
}
/*</listing>*/
