package A4_Q2;


public class A4_Q2_B2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String value = InfixToPostfixParens.convert( "(x+15)*(3*(4-(5+7/2)))" );
		String value = InfixToPostfixParens.convert( "(G-W)*(F+Q)/((A-B)*(X-Y))" );
		System.out.println("InFixToPostfix class result is: " + value);
		
		/**
		 * Manual Trace the evaluation 
		 * showing the operand stack each time it is
		 * modified
		 */
		
	

		System.out.println("             Token "+"            Action  "+"              Stack  "+"   PostFix");
		System.out.println("| ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add ( to stack"+"           [(]  "+"      "); 
		System.out.println("");
		System.out.println(" | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add x  to pf"+"             [(]  "+"        x "); 
		System.out.println("");
		System.out.println("  | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add +  to stack"+"          [+, (]  "+"     x "); 
		System.out.println("");
		System.out.println("    | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add 15 to pf"+"             [+, (]  "+"     x 15 "); 
		System.out.println("");
		System.out.println("     | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       ) preceeds +" ); 
		System.out.println("                     "+"         pop + and add it pf"+"    [(]"+"          x 15 +"); 
		System.out.println("                     "+"       ) precedence equals (" ); 
		System.out.println("                     "+"       ) precedence equals (" ); 
		System.out.println("                     "+"         left patter found " ); 
		System.out.println("                     "+"         pop (   "+"               []"+"           x 15 +");  
		System.out.println("");
		System.out.println("      | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add *  to stack"+"          [*]  "+"        x 15 + "); 
		System.out.println("");
		System.out.println("       | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add (  to stack"+"          [(, *]  "+"     x 15 + "); 
		System.out.println("");
		System.out.println("        | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add 3  to pf   "+"        [(, *]    "+"     x 15 + 3"); 
		System.out.println("");
		System.out.println("         | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add *  to stack"+"        [*, (, *]    "+"  x 15 + 3"); 
		System.out.println("");
		System.out.println("          | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add (  to stack"+"        [(, *, (, *]    "+"x 15 + 3"); 
		System.out.println("");
		System.out.println("           | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add 4  to pf   "+"        [(, *, (, *]    "+"x 15 + 3 4"); 
		System.out.println("");
		System.out.println("            | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add - to stack "+"        [-, (, *, (, *]   "+"x 15 + 3 4"); 
		System.out.println("");
		System.out.println("             | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add ( to stack "+"        [(, -, (, *, (, *]   "+"x 15 + 3 4"); 
		System.out.println("");
		System.out.println("              | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add 5 to pf    "+"        [(, -, (, *, (, *]   "+"x 15 + 3 4 5"); 
		System.out.println("");
		System.out.println("               | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add + to stack "+"        [+, (, -, (, *, (, *]   "+"x 15 + 3 4 5"); 
		System.out.println("");
		System.out.println("                | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add 7 to pf    "+"        [+, (, -, (, *, (, *]   "+"x 15 + 3 4 5 7"); 
		System.out.println("");
		System.out.println("                 | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add / to stack "+"        [/, +, (, -, (, *, (, *]   "+"x 15 + 3 4 5 7"); 
		System.out.println("");
		System.out.println("                  | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       add 2 to pf    "+"        [/, +, (, -, (, *, (, *]   "+"x 15 + 3 4 5 7 2"); 
		System.out.println("");
		System.out.println("                   | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       pop / and +          "); 
		System.out.println("                     "+"       add / and + to pf"+"      [(, -, (, *, (, *]   "+"x 15 + 3 4 5 7 2 / +"); 
		System.out.println("                     "+"       pop (");
		System.out.println("                     "+"       discard ) and ("+"        [-, (, *, (, *]   "+"   x 15 + 3 4 5 7 2 / +"); 
		System.out.println("");
		System.out.println("                    | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       pop -          "); 
		System.out.println("                     "+"       add -  to pf");
		System.out.println("                     "+"       discard ) and ("+"           [*, (, *]   "+"         x 15 + 3 4 5 7 2 / + - "); 
		System.out.println("");
		System.out.println("                     | ");
		System.out.println("(x+15)*(3*(4-(5+7/2))"+"       pop *        "); 
		System.out.println("                     "+"       add *  to pf"+"              [(, *]   "+"               x 15 + 3 4 5 7 2 / + - *"); 
		System.out.println("                     "+"       pop (       "+"              [(, *]   "+"               x 15 + 3 4 5 7 2 / + - *");
		System.out.println("                     "+"       set foundLeftPattern=F"+"    [*]   "+"                  x 15 + 3 4 5 7 2 / + - *");
		System.out.println("                     "+"       pop *        "); 
		System.out.println("                     "+"       add *  to pf"+"              []   "+"                   x 15 + 3 4 5 7 2 / + - * *");
		System.out.println("                     "+"       stack empty"+"               []   ");
		System.out.println("                     "+"       add *  to pf"+"              []   "+"                   x 15 + 3 4 5 7 2 / + - * *");
		System.out.println("                     "+"       stack Empty "+"              []   "+"                   x 15 + 3 4 5 7 2 / + - * *");
		System.out.println("                     "+"       Un-matched Right Paren Exeption Thrown"+"            "+"                   ");
	}
}
