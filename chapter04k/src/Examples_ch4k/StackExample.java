package Examples_ch4k;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<String> games = new Stack<String>();
		
		games.add("call of duty");
		games.add("guitar hero");
		games.add("super monkey balls");
		
		System.out.println(games);
		System.out.println(games.pop());
		System.out.println(games);
		
		
	}

}
