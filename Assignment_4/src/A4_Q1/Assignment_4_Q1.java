package A4_Q1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Assignment_4_Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * creating two stacks and a queue:
		 * stack1
		 * stack2
		 * queue1
		 */
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Queue<Integer> queue1 = new LinkedList<Integer>();
		
		/**
		 * add values:
		 * -1, 15, 23, 44, 4, 99
		 * to stack1
		 */
		stack1.add(-1);
		stack1.add(15);
		stack1.add(23);
		stack1.add(44);
		stack1.add(4);
		stack1.add(99);
		
		/**
		 * verifying to of stack1 contains 99
		 */
		System.out.println("top of stack1 contains value: " + stack1.peek());
		
		/**
		 * add values of stack1
		 * to stack2 and queue1
		 */		
		while(!stack1.empty()) {
			int value = stack1.pop();
			stack2.add(value);
			queue1.add(value);
		}
		
		/**
		 * remove values from stack2 and queue1
		 * and display the pair of values
		 */
		while(!stack2.empty()) {
			System.out.println("removed values " +stack2.pop() +" from stack and "+queue1.poll() +" from queue");
		}
	}

}
