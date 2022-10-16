package examples;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> linky = new LinkedList<String>();
		
		linky.add("rob");
		linky.add("lee");
		linky.add("jose");
		linky.add("ali");
		
		//System.out.println(linky);
//		System.out.println(linky.getLast());
//		System.out.println(linky.getFirst());
		
		System.out.println(linky);
		
		Iterator it = linky.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

}
