/*<listing chapter="6" section="4">*/
package A5_Q1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to represent a binary search tree.
 *
 * @param <E> The element type
 * @author Koffman and Wolfgang
 */
public class BinarySearchTree<E extends Comparable<E>>
        extends BinaryTree<E>
        implements SearchTree<E> {
    
    /**
     * Package Private constructor for testing.
     */
    BinarySearchTree (E theData, BinarySearchTree<E> left, BinarySearchTree<E> right) {
        super(theData, left, right);
        size = 0;
    }
    
    /**
     * Public no-argument constructor.
     */
    public BinarySearchTree() {
        super();
    }
    
    /**
     * The number of items in the tree;
     */
    protected int size;
    
    /**
     * Return the number of items in the tree.
     * @return The size of the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return value from the public add method.
     */
    protected boolean addReturn;
    /**
     * Return value from the public delete method.
     */
    protected E deleteReturn;
    protected E removeReturn;

    //Methods
    /*<listing chapter="6" number="4">*/
    /**
     * Starter method find.
     *
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    @Override
    public E find(E target) {
        return find(root, target);
    }

    /**
     * Recursive find method.
     *
     * @param localRoot The local subtree�s root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    private E find(BinaryNode<E> localRoot, E target) {
        if (localRoot == null) {
            return null;
        }

        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.getData());
        if (compResult == 0) {
            return localRoot.getData();
        } else if (compResult < 0) {
            return find(localRoot.getLeftChild(), target);
        } else {
            return find(localRoot.getRightChild(), target);
        }
    }
    /*</listing>*/

    /*<listing chapter="6" number="5">*/
    /**
     * Starter method add.
     *
     * @param item The object being inserted
     * @return true if the object is inserted, false if the object already
     * exists in the tree
     */
    @Override
    public boolean add(E item) {
        root = add(root, item);
        if (addReturn) {
            size++;
        }
        return addReturn;
    }

    /**
     * Recursive add method.
     *
     * postThe data field addReturn is set true if the item is added to the
     * tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the inserted item
     */
    protected BinaryNode<E> add(BinaryNode<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree � insert it.
            addReturn = true;
            return new BinaryNode<>(item);
        } else if (item.compareTo(localRoot.getData()) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.getData()) < 0) {
            // item is less than localRoot.data
          //  localRoot.left = add(localRoot.left, item);  
            localRoot.setLeftChild(add(localRoot.getLeftChild(), item));
            return localRoot;
        } else {
            // item is greater than localRoot.data
         //   localRoot.right = add(localRoot.right, item);
            localRoot.setRightChild(add(localRoot.getRightChild(), item));
            return localRoot;
        }
    }
    /*</listing>*/

    /*<listing chapter="6" number="6">*/
    /**
     * Starter method delete.
     *
     * postThe object is not in the tree.
     * @param target The object to be deleted
     * @return The object deleted from the tree or null if the object was not in
     * the tree
     */
    @Override
    public E delete(E target) {
        root = delete(root, target);
        if (deleteReturn != null) {
            size--;
        }
        return deleteReturn;
    }

    /**
     * Recursive delete method.
     *
     * postThe item is not in the tree; deleteReturn is equal to the deleted
     * item as it was stored in the tree or null if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain the item
     */
    private BinaryNode<E> delete(BinaryNode<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.getData());
        if (compResult < 0) {
            // item is smaller than localRoot.data.
          //  localRoot.left = delete(localRoot.left, item);
            localRoot.setLeftChild(delete(localRoot.getLeftChild(), item));
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            //localRoot.right = delete(localRoot.right, item);
            localRoot.setRightChild(delete(localRoot.getRightChild(), item));
            return localRoot;
        } else {
            // item is at local root.
            //deleteReturn = localRoot.data;
            deleteReturn = localRoot.getData();
            if (localRoot.getLeftChild() == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.getRightChild();
            } else if (localRoot.getRightChild() == null) {
                // If there is no right child, return left child.
                return localRoot.getLeftChild();
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.getLeftChild().getRightChild() == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                   // localRoot.data = localRoot.left.data;
                    localRoot.setData(localRoot.getLeftChild().getData());
                    // Replace the left child with its left child.
                   // localRoot.left = localRoot.left.left;
                    localRoot.setLeftChild(localRoot.getLeftChild().getLeftChild());
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                  //  localRoot.data = findLargestChild(localRoot.left);
                    localRoot.setData(findLargestChild((localRoot.getLeftChild())));
                    return localRoot;
                }
            }
        }
    }
    /*</listing>*/
    @Override
    public boolean remove(E target) {
        root = remove(root, target);
        if (removeReturn != null) {
            size--;
        }
        if (removeReturn == null) {
        	return false;
        }else {
        	return true;
        }
    }
    private BinaryNode<E> remove(BinaryNode<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
        	removeReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.getData());
        if (compResult < 0) {
            // item is smaller than localRoot.data.
          //  localRoot.left = delete(localRoot.left, item);
            localRoot.setLeftChild(delete(localRoot.getLeftChild(), item));
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            //localRoot.right = delete(localRoot.right, item);
            localRoot.setRightChild(delete(localRoot.getRightChild(), item));
            return localRoot;
        } else {
            // item is at local root.
            //deleteReturn = localRoot.data;
        	removeReturn = localRoot.getData();
            if (localRoot.getLeftChild() == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.getRightChild();
            } else if (localRoot.getRightChild() == null) {
                // If there is no right child, return left child.
                return localRoot.getLeftChild();
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.getLeftChild().getRightChild() == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                   // localRoot.data = localRoot.left.data;
                    localRoot.setData(localRoot.getLeftChild().getData());
                    // Replace the left child with its left child.
                   // localRoot.left = localRoot.left.left;
                    localRoot.setLeftChild(localRoot.getLeftChild().getLeftChild());
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                  //  localRoot.data = findLargestChild(localRoot.left);
                    localRoot.setData(findLargestChild((localRoot.getLeftChild())));
                    return localRoot;
                }
            }
        }
    }
// Insert solution to programming exercise 1, section 5, chapter 06 here

    /*<listing chapter="6" number="7">*/
    /**
     * Find the node that is the in-order predecessor and replace it with its
     * left child (if any).
     *
     * postThe in-order predecessor is removed from the tree.
     * @param parent The parent of possible in-order predecessor (ip)
     * @return The data in the ip
     */
    private E findLargestChild(BinaryNode<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.getRightChild().getRightChild() == null) {
            E returnValue = parent.getRightChild().getData();
            //parent.right = parent.right.left;
            parent.setRightChild(parent.getRightChild().getLeftChild());
            return returnValue;
        } else {
            return findLargestChild(parent.getRightChild());
        }
    }
    /*</listing>*/

// Insert solution to programming exercise 2, section 5, chapter 06 here

// Insert solution to programming exercise 3, section 5, chapter 06 here

    /**
     * Empty this BinarySearchTree
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
	private class InorderIterator implements Iterator<E>
	{
      private StackInterface<BinaryNode<E>> nodeStack;
      private BinaryNode<E> currentNode;

      public InorderIterator()
      {
         nodeStack = new LinkedStack<>();
         currentNode = root;
      } // end default constructor

      public boolean hasNext() 
      {
         return !nodeStack.isEmpty() || (currentNode != null);
      } // end hasNext

      public E next()
      {
         BinaryNode<E> nextNode = null;

         // Find leftmost node with no left child
         while (currentNode != null)
         {
            nodeStack.push(currentNode);
            currentNode = currentNode.getLeftChild();
         } // end while

         // Get leftmost node, then move to its right subtree
         if (!nodeStack.isEmpty())
         {
            nextNode = nodeStack.pop();
            assert nextNode != null; // Since nodeStack was not empty
                                     // before the pop
            currentNode = nextNode.getRightChild();
         }
         else
            throw new NoSuchElementException();

         return nextNode.getData(); 
      } // end next

    //......................................

      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
	} // end InorderIterator

	@Override
	public boolean contains(E target) {
		if (find(target) != null) {
			return true;
		}	
		return false;
	}

	@Override
	public List<E> toList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
/*</listing>*/
