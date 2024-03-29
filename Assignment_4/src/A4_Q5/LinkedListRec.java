/*<listing chapter="5" section="4">*/
package A4_Q5;

/**
 * A recursive linked list class with recursive methods.
 * @param <E> The element type
 * @author Koffman and Wolfgang
 **/
public class LinkedListRec<E> {

    /** The list head */
    private Node<E> head;

    /** A Node is the building block for a single-linked list. */
    private static class Node<E> {
        // Data Fields

        /** The reference to the data. */
        private E data;
        /** The reference to the next node. */
        private Node<E> next;

        // Constructors
        /**
         * Creates a new node with a null next field.
         * @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         * @param dataItem The data stored
         * @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    } //end class Node

    /**
     * Finds the size of a list.
     * @param head The head of the current list
     * @return The Size of the Current List
     */
    private int size(Node<E> head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + size(head.next);
        }
    }

    /**
     * Wrapper method for finding the size of a list.
     * @return The size of the list
     */
    public int size() {
        return size(head);
    }

    /**
     * Returns the string representation of a list.
     * @param head The head of the current list
     * @return The state of the current list
     */
    private String toString(Node<E> head) {
        if (head == null) {
            return "";
        } else {
            return head.data + "\n" + toString(head.next);
        }
    }

    /**
     * Wrapper method for returning the string representation of a list.
     * @return The string representation of the list
     */
    @Override
    public String toString() {
        return toString(head);
    }

    /**
     * Replaces all occurrences of oldObj with newObj.
     * postEach occurrence of oldObj has been replaced by newObj.
     * @param head The head of the current list
     * @param oldObj The object being removed
     * @param newObj The object being inserted
     */
    private void replace(Node<E> head, E oldObj, E newObj) {
        if (head != null) {
            if (oldObj.equals(head.data)) {
                head.data = newObj;
            }
            replace(head.next, oldObj, newObj);
        }
    }

    /*
     Wrapper method for replacing oldObj with newObj.
     * postEach occurrence of oldObj has been replaced by newObj.
     * @param oldObj The object being removed
     * @param newObj The object being inserted
     */
    public void replace(E oldObj, E newObj) {
        replace(head, oldObj, newObj);
    }

    
    
    
    
    
    
    
    // ------------------------------------------------------------------ Add After Methods by Yassine, Assignemnt A4 Q5
    /**
     * finds the target Node by matching the Node data
     * and adds a new node with use passed Data
     * 
     * @param existingData to match the existing node
     * @param newData to create the new Node
     */
    private void addAfter(Node<E> evaluatedNode, E existingData, E newData) {
    	if (evaluatedNode.data.equals(existingData)) {
    		Node<E> temp = new Node<>(newData, evaluatedNode.next );
    		evaluatedNode.next = temp;
    	} else {
    		addAfter(evaluatedNode.next, existingData, newData);
    	}
    }
    
    /**
     * Wrapper method for adding a new node
     * after a specified node
     * 
     * @param existingNode to add after
     * @param newNode to add
     */
    public void addAfter(Node<E> existingNode, Node<E> newNode) {
	    if (head == null) {
	    	System.out.println("list is empty");
	    } else {
	    	addAfter(head, existingNode.data, newNode.data);
	    }	
    }
    // ----------------------------------------------------------------------------------------End of Assignment problem
    
    
    
    
    
    
    
    
    /**
     * Adds a new node to the end of a list.
     * @param head The head of the current list
     * @param data The data for the new node
     */
    private void add(Node<E> head, E data) {
        // If the list has just one element, add to it.
        if (head.next == null) {
            head.next = new Node<>(data);
        } else {
            add(head.next, data); // Add to rest of list.
        }
    }

    /**
     * Wrapper method for adding a new node to the end of a list.
     * @param data The data for the new node
     */
    public void add(E data) {
        if (head == null) {
            head = new Node<>(data); // List has 1 node.
        } else {
            add(head, data);
        }
    }

    /**
     * Removes a node from a list.
     * postThe first occurrence of outData is removed.
     * @param head The head of the current list
     * @param pred The predecessor of the list head
     * @param outData The data to be removed
     * @return true if the item is removed
     *         and false otherwise
     */
    private boolean remove(Node<E> head, Node<E> pred, E outData) {
        if (head == null) // Base case --  empty list.
        {
            return false;
        } else if (head.data.equals(outData)) { // 2nd base case.
            pred.next = head.next; // Remove head.
            return true;
        } else {
            return remove(head.next, head, outData);
        }
    }

    /**
     * Wrapper method for removing a node (in LinkedListRec).
     * postThe first occurrence of outData is removed.
     * @param outData The data to be removed
     * @return true if the item is removed,
     *         and false otherwise
     */
    public boolean remove(E outData) {
        if (head == null) {
            return false;
        } else if (head.data.equals(outData)) {
            head = head.next;
            return true;
        } else {
            return remove(head.next, head, outData);
        }
    }

// Insert solution to programming exercise 1, section 4, chapter 05 here

    @Override
    public int hashCode() {
        int hash = 7;
        return hashCode(head, hash);
    }
    
    private int hashCode(Node<E> node, int hash) {
        if (node == null) {
            return hash;
        } else {
            hash *= 19;
            return hashCode(node.next, hash);
        }
    }
// Insert solution to programming exercise 2, section 4, chapter 05 here

// Insert solution to programming exercise 3, section 4, chapter 05 here

// Insert solution to programming exercise 4, section 4, chapter 05 here

// Insert solution to programming exercise 5, section 4, chapter 05 here

// Insert solution to programming exercise 6, section 4, chapter 05 here

// Insert solution to programming project 4, chapter 04 here
    
// Insert solution to programming project 4, chapter 05 here
    
}
/*</listing>*/
