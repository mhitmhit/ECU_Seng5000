package Examples;

/**
 * A recursive linked list class with recursive methods.
 * 
 * @param <E> The element type
 **/
public class LinkedListRec<E> {

	private Node<E> head;

	private static class Node<E> {
		// Data Fields
		private E data;
		private Node<E> next;

		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}

		/**
		 * Creates a new node that references another node.
		 */
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	} // end class Node

	public void insertBefore(E target, E inData) {
		if (head == null) {
			head = new Node<>(target, null);
			return;
		}
		if (head.data.equals(target)) {
			head = new Node<>(inData, head);
			return;
		}
		insertBefore(target, inData, head);
	}

	/**
	 * Recursive method to insert a specified data object before the first
	 * occurrence of another specified data object. If the object is not found, then
	 * the item is inserted at the end of the list.
	 * 
	 * @param target the item that inData is to be inserted before
	 * @param inData the item to be inserted
	 * @param node   the current node
	 */
	private void insertBefore(E target, E inData, Node<E> node) {
		if (node.next == null) {
			node.next = new Node<>(inData, null);
			return;
		}
		if (target.equals(node.next.data)) {
			node.next = new Node<>(inData, node.next);
			return;
		}
		insertBefore(target, inData, node.next);
	}


	public void insertAfter(E target, E inData) {
		if (head == null) {
			head = new Node<>(target, null);
			return;
		}
		if (head.data.equals(target)) {
			head.next = new Node<>(inData, head.next);
			return;
		}
		insertAfter(target, inData, head);
	}

	/**
	 * Recursive method to insert a specified data object after the first occurrence
	 * of another specified data object. If the object is not found, then the item
	 * is inserted at the end of the list.
	 * 
	 * @param target the item that inData is to be inserted after
	 * @param inData the item to be inserted
	 * @param node   the current node
	 */
	private void insertAfter(E target, E inData, Node<E> node) {

	}

	private int size(Node<E> head) {
		if (head == null) {
			return 0;
		} else {
			return 1 + size(head.next);
		}
	}

	public int size() {
		return size(head);
	}

	private String toString(Node<E> head) {
		if (head == null) {
			return "";
		} else {
			return head.data + "\n" + toString(head.next);
		}
	}

	@Override
	public String toString() {
		return toString(head);
	}
	private void replace(Node<E> head, E oldObj, E newObj) {
		if (head != null) {
			if (oldObj.equals(head.data)) {
				head.data = newObj;
			}
			replace(head.next, oldObj, newObj);
		}
	}

	public void replace(E oldObj, E newObj) {
		replace(head, oldObj, newObj);
	}

	private void add(Node<E> head, E data) {
		// If the list has just one element, add to it.
		if (head.next == null) {
			head.next = new Node<>(data);
		} else {
			add(head.next, data); // Add to rest of list.
		}
	}

	public void add(E data) {
		if (head == null) {
			head = new Node<>(data); // List has 1 node.
		} else {
			add(head, data);
		}
	}


}