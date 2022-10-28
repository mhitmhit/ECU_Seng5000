package A4_Q2;

public class A4_Q2_A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int value = PostfixEvaluator.eval("13 2 * 5 / 6 2 5 * - +");
		System.out.println("PostFixEvaluator class result is: " + value);
		
		/**
		 * Manual Trace the evaluation 
		 * showing the operand stack each time it is
		 * modified
		 */
		System.out.println("       Expression "+"          Action  "+"               Stack");
		System.out.println("| ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      push 13"+"                [13]"); 
		System.out.println("");
		System.out.println("   | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      push 2"+"                 [2, 13]");
		System.out.println("");
		System.out.println("     | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      pop 2 and 13");
		System.out.println("                       "+"      mult 2 and 13");
		System.out.println("                       "+"      push 26"+"                [26]");
		System.out.println("");
		System.out.println("       | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      push 5"+"                 [5, 26]");
		System.out.println("");
		System.out.println("         | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      pop 5 and 26");
		System.out.println("                       "+"      divde 26 by 5");
		System.out.println("                       "+"      push 5"+"                 [5]");
		System.out.println("");
		System.out.println("           | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      push 6"+"                 [6, 5]");
		System.out.println("");
		System.out.println("             | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      push 2"+"                 [2, 6, 5]");
		System.out.println("");
		System.out.println("               | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      push 5"+"                 [5, 2, 6, 5]");
		System.out.println("");
		System.out.println("                 | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      pop 5 and 2");
		System.out.println("                       "+"      mult 2 and 5");
		System.out.println("                       "+"      push 10"+"                [10, 6, 5]");
		System.out.println("");
		System.out.println("                   | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      pop 10 and 6");
		System.out.println("                       "+"      sub 10 from 6");
		System.out.println("                       "+"      push -4"+"                [-4, 5]");
		System.out.println("");
		System.out.println("                     | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      pop -4 and 5");
		System.out.println("                       "+"      add -4 and 5");
		System.out.println("                       "+"      push 1"+"                 [1]");
		System.out.println("");
		System.out.println("                       | ");
		System.out.println("13 2 * 5 / 6 2 5 * - + "+"      pop 1  "+"                []");
	}

}
