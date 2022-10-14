package A3_Q1;
import java.util.*;

/** This class implements some of the methods of the Java ArrayList class
*/
public class KWArrayList<E> {
  // Data fields
  /** The default initial capacity */
  private static final int INITIAL_CAPACITY = 10;

  /** The underlying data array */
  private E[] theData;

  /** The current size */
  private int size = 0;

  /** The current capacity */
  private int capacity = 0;
  
  public KWArrayList () {
	    capacity = INITIAL_CAPACITY;
	    theData = (E[]) new Object[capacity];
	}
  /**
   * Constructor that takes a capacity value
   * and creates and array of passed in capacity
   * @param capacity
   */
  public KWArrayList (int capacity) {
	  	this.capacity = capacity;
	  	theData = (E[]) new Object[capacity];
  }

  public void add (int index, E anEntry) {
	  // check bounds
	  if (index < 0 || index > size) {
	    throw new ArrayIndexOutOfBoundsException(index); 
	  }

	  // Make sure there is room
	  if (size >= capacity) { 
	    reallocate(); 
	  }

	  // shift data
	  for (int i = size; i > index; i--) {
	    theData[i] = theData[i-1];
	  }

	  // insert item
	  theData[index] = anEntry;
	  size++;
	}

  public E get (int index) {
	  if (index < 0 || index >= size) {
	    throw new ArrayIndexOutOfBoundsException(index);
	  }
	  return theData[index];
	}

	public E set (int index, E newValue) {
	  if (index < 0 || index >= size) {
	    throw new ArrayIndexOutOfBoundsException(index);
	  }
	  E oldValue = theData[index];
	  theData[index] = newValue;
	  return oldValue;
	}

	public E remove (int index) {

		  if (index < 0 || index >= size) {
		    throw new ArrayIndexOutOfBoundsException(index);
		  }

		  E returnValue = theData[index];

		  for (int i = index + 1; i < size; i++) {
		    theData[i-1] = theData[i];
		  }

		  size--;
		  return returnValue;
		}

	private void reallocate () {
		  capacity *= 2; 
		  theData = Arrays.copyOf(theData, capacity);
		}
	
	/**
	 * 
	 * @param element of type E
	 * @return index position of item in the data Array.
	 * 		   if item is not found, it returns -1.
	 */
	public int indexOf(E element) {
		int position = -1;
		for (int i=0; i < size ; i++) {
			if (theData[i].equals(element)) {
					position = i;
			}
		}
		return position;
	}

	
  
}

