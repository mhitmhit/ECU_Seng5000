package A4_Q2;

public class A4_Q2_B1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = InfixToPostfix.convert("y - 7 / 35 + 4 * 6 - 10");
		System.out.println("InFixToPostfix class result is: " + value);
		
		/**
		 * Manual Trace the evaluation 
		 * showing the operand stack each time it is
		 * modified
		 */
		
		System.out.println("             Token "+"            Action  "+"              Stack  "+"   PostFix");
		System.out.println("| ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add y to postFix"+"          []  "+"      y"); 
		System.out.println("");
		System.out.println("  | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add - to stack"+"            [-]  "+"     y"); 
		System.out.println("");
		System.out.println("    | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add 7 to postFix"+"          [-]  "+"     y 7"); 
		System.out.println("");
		System.out.println("      | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add / to stack"+"            [/, -]  "+"  y 7"); 
		System.out.println("");
		System.out.println("        | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add 35 to pf"+"              [/, -]  "+"  y 7 35"); 
		System.out.println("");
		System.out.println("           | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       / preceeds +"+"               "+"     "); 
		System.out.println("                       "+"       pop / and add to pf"+"       [-]       "+"y 7 35 /"); 
		System.out.println("                       "+"       + precedence equals -"+"               "+"     "); 
		System.out.println("                       "+"       pop - and add to pf"+"       []        "+"y 7 35 / -"); 
		System.out.println("                       "+"       Add + to stack"+"            [+]       "+"y 7 35 / -"); 
		System.out.println("");
		System.out.println("             | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add 4 to pf"+"               [+]     "+"  y 7 35 / - 4"); 
		System.out.println("");
		System.out.println("               | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add * to stack"+"            [*, +]    "+"y 7 35 / - 4"); 
		System.out.println("");
		System.out.println("                 | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add 6 to pf"+"               [*, +]  "+"  y 7 35 / - 4 6"); 
		System.out.println("");
		System.out.println("                   | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       * preceeds -"+"               "+"     "); 
		System.out.println("                       "+"       pop * and add to pf"+"       [+]       "+"y 7 35 / - 4 6 *"); 
		System.out.println("                       "+"       + precedence equals -"+"               "+"     "); 
		System.out.println("                       "+"       pop + and add to pf"+"       []        "+"y 7 35 / - 4 6 * +"); 
		System.out.println("                       "+"       Add - to stack"+"            [-]       "+"y 7 35 / - 4 6 * +"); 
		System.out.println("");
		System.out.println("                     | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       Add 10 to pf"+"              [-]     "+"  y 7 35 / - 4 6 * + 10"); 
		System.out.println("");
		System.out.println("                        | ");
		System.out.println("y - 7 / 35 + 4 * 6 - 10"+"       pop + and add to pf"+"       []     "+"   y 7 35 / - 4 6 * + 10 -"); 
		System.out.println("");
	}

}
