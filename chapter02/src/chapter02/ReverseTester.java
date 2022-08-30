package chapter02;

public class ReverseTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder word = new StringBuilder("desserts");
		
		System.out.println("original value: " + word);
		
		String word2 = word.reverse().toString();
		
		System.out.println("reversed value: " + word2);
	}

}
