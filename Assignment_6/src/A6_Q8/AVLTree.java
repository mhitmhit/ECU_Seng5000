package A6_Q8;

/*<listing chapter="9" section="2">*/
/**
 * Self-balancing binary search tree using the algorithm defined
 * by Adelson-Velskii and Landis.
 * @param <E> The element type
 * @author Koffman and Wolfgang
 */
public class AVLTree<E extends Comparable<E>>
         extends BinarySearchTreeWithRotate<E> {

    // Insert nested class AVLNode<E> here.
    /*<listing chapter="9" number="2">*/
    /** Class to represent an AVL Node. It extends the
     * BinaryTree.Node by adding the balance field.
     */
    private static class AVLNode<E> extends Node<E> {

        /** Constant to indicate left-heavy */
        public static final int LEFT_HEAVY = -1;
        /** Constant to indicate balanced */
        public static final int BALANCED = 0;
        /** Constant to indicate right-heavy */
        public static final int RIGHT_HEAVY = 1;
        /** balance is right subtree height - left subtree height */
        private int balance;

        // Methods
        /**
         * Construct a node with the given item as the data field.
         * @param item The data field
         */
        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        /**
         * Return a string representation of this object.
         * The balance value is appended to the contents.
         * @return String representation of this object
         */
        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }
    /*</listing>*/
    
    private int size;
    
    public int size() {
        return size;
    }
    
    // Data Fields
    /** Flag to indicate that height of tree has increased. */
    private boolean increase;

// Insert solution to programming project 5, chapter 09 here

    // Methods
    /**
     * add starter method.
     * pre: the item to insert implements the Comparable interface.
     * @param item The item being inserted.
     * @return true if the object is inserted; false
     *         if the object already exists in the tree
     * @throws ClassCastException if item is not Comparable
     */
    @Override
    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        if (addReturn) {
            size++;
        }
        return addReturn;
    }

    /**
     * Recursive add method. Inserts the given object into the tree.
     * postaddReturn is set true if the item is inserted,
     *       false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root of the subtree with the item
     *         inserted
     */
    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<>(item);
        }

        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item < data
            localRoot.left = add((AVLNode<E>) localRoot.left, item);

            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        } else { 
// *********************************************************************************************Inserted Code for item > data use case
        	// item > data
        	localRoot.right = add((AVLNode<E>) localRoot.right, item);
        	if (increase) {
        		incrementBalance(localRoot);
        		if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
        			increase = false;
        			return rebalanceRight(localRoot);
        		}
        	}
        	return localRoot;
// *********************************************************************************************Inserted Code End for item > data use case
        }
    }

    /*<listing chapter="9" number="3">*/
    /**
     * Method to rebalance left.
     * preocalRoot is the root of an AVL subtree that is
     *      critically left-heavy.
     * postBalance is restored.
     * @param localRoot Root of the AVL subtree
     *        that needs rebalancing
     * @return a new localRoot
     */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
        // Obtain reference to left child.
        var leftChild = (AVLNode<E>) localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child.
            var leftRightChild = (AVLNode<E>) leftChild.right;
            // Adjust the balances to be their new values after
            // the rotations are performed.
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.left = rotateLeft(leftChild);
        } else { //Left-Left case
            // In this case the leftChild (the new root)
            // and the root (new right child) will both be balanced
            // after the rotation.
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate the local root right.
        return (AVLNode<E>) rotateRight(localRoot);
    }
 // *********************************************************************************************Inserted Code for rebalance Right
    /**
     * Method to rebalance right.
     * prelocalRoot is the root of an AVL subtree that is
     *      critically right-heavy.
     * postBalance is restored.
     * @param localRoot Root of the AVL subtree
     *        that needs rebalancing
     * @return a new localRoot
     */
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {
    	//Obtain reference to right child
		var rightChild = (AVLNode<E>) localRoot.right;
		//see whether right-left heavy
		if(rightChild.balance < AVLNode.BALANCED){
			//Obtain reference to right-left child.
			AVLNode<E> RightLeftChild = (AVLNode<E>) rightChild.left;
			// Adjust the balances to be their new values after
			// the rotations are performed
			if(RightLeftChild.balance < AVLNode.BALANCED){
				rightChild.balance = AVLNode.RIGHT_HEAVY;
				RightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			} else if (RightLeftChild.balance > AVLNode.BALANCED){
				rightChild.balance = AVLNode.BALANCED;
				RightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.LEFT_HEAVY;
			} else {
				rightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			//Perform right rotation
			localRoot.right = rotateRight(rightChild);
		 } else { //Left-Left case
		    // In this case the rightChild (the new root)
		    // and the root (new right child) will both be balanced
		    // after the rotation.
			rightChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		//now rotate the local root left
		return (AVLNode<E>) rotateLeft(localRoot);
    }
 // *********************************************************************************************Inserted Code End for rebalance right
    /**
     * Method to decrement the balance field and to reset the value of
     * increase.
     * prehe balance field was correct prior to an insertion [or
     *      removal,] and an item is either been added to the left[
     *      or removed from the right].
     * postThe balance is decremented and the increase flags is set
     *       to false if the overall height of this subtree has not
     *       changed.
     * @param node The AVL node whose balance is to be incremented
     */
    private void decrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not increased.
            increase = false;
        }
    }
    
 // *********************************************************************************************Inserted Code  for Increment Balance
    /**
     * Method to increment the balance field and to reset the value of
     * increase.
     * prehe balance field was correct prior to an insertion [or
     *      removal,] and an item is either been added to the right[
     *      or removed from the left].
     * postThe balance is incremented and the increase flags is set
     *       to false if the overall height of this subtree has not
     *       changed.
     * @param node The AVL node whose balance is to be incremented
     */
    private void incrementBalance(AVLNode<E> node) {
    	// Increment the balance
    	node.balance++;
    	if (node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not increased.
            increase = false;
        }
    }
 // *********************************************************************************************Inserted Code End for Increment Balance

// Insert solution to programming exercise 3, section 2, chapter 09 here

// Insert solution to programming project 5, chapter 09 here
    
// Insert solution to programming project 1, chapter 09 here
    
}
