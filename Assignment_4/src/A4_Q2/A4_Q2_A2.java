package A4_Q2;

public class A4_Q2_A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int value = PostfixEvaluator.eval("5 4 * 6 7 + 4 2 / - *");
		int value = PostfixEvaluator.eval("8 12 3 * + 5 -");
		System.out.println("PostFixEvaluator class result is: " + value);
		
		/**
		 * Manual Trace the evaluation 
		 * showing the operand stack each time it is
		 * modified
		 */
		System.out.println("       Expression "+"          Action  "+"               Stack");
		System.out.println("| ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        push 5"+"                [5]"); 
		System.out.println("");
		System.out.println("  | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        push 4"+"                [4, 5]"); 
		System.out.println("");
		System.out.println("    | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        pop 4 and 5"+"            ");
		System.out.println("                       "+"      mult 4 and 5");
		System.out.println("                       "+"      push 20"+"               [20]");
		System.out.println("");
		System.out.println("      | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        push 6"+"                [6, 20]"); 
		System.out.println("");
		System.out.println("        | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        push 7"+"                [7, 6, 20]"); 
		System.out.println("");
		System.out.println("          | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        pop 7 and 6"+"            ");
		System.out.println("                       "+"      add 7 and 6");
		System.out.println("                       "+"      push 13"+"               [13, 20]");
		System.out.println("");
		System.out.println("            | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        push 4"+"                [4, 13, 20]"); 
		System.out.println("");
		System.out.println("              | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        push 2"+"                [2, 4, 13, 20]"); 
		System.out.println("");
		System.out.println("                | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        pop 4 and 2"+"            ");
		System.out.println("                       "+"      div 4 by 2");
		System.out.println("                       "+"      push 2"+"                [2, 13, 20]");
		System.out.println("");
		System.out.println("                  | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        pop 2 and 13"+"            ");
		System.out.println("                       "+"      sub 2 from 13");
		System.out.println("                       "+"      push 11"+"               [11, 20]");
		System.out.println("");
		System.out.println("                    | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        pop 11 and 20"+"            ");
		System.out.println("                       "+"      mult 11 by 20");
		System.out.println("                       "+"      push 220"+"               [220]");
		System.out.println("");
		System.out.println("                      | ");
		System.out.println("5 4 * 6 7 + 4 2 / - *"+"        pop 220"+"                []"); 
		System.out.println("");

	}

}
