package Examples_ch4k;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String> tester = new LinkedList<String>();
		
		tester.add("value 1");
		tester.add("value 2");
		tester.add("value 3");
		
		System.out.println(tester);
		
		tester.poll();
		
		System.out.println(tester);
		
		
		
	}

}
