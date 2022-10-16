package examples;

public class DoublyLinkedList<E> {

	private ListNode head;
	private ListNode tail;
	private int length;
	
	private class ListNode {
		private E data;
		private ListNode next = null;
		private ListNode prev = null;

		private ListNode(E data) {
			this.data = data;
			
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0; // head == null;
	}
	
	public int length() {
		return length;
	}
	
	public void display() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
		System.out.print("null");
	}
	
	public void addLast(E value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			head = newNode;
		}else {
			tail.next = newNode;
		}
		newNode.prev = tail;
		tail = newNode;
		length++;
	}
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> doubly = new DoublyLinkedList<Integer>();
		doubly.addLast(10); // head
		doubly.addLast(12);
		doubly.addLast(13);
		doubly.display();
		
	}
	
}
