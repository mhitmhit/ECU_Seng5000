package A4_Q2;


public class A4_Q2_B2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = InfixToPostfixParens.convert( "(x+15)*(3*(4-(5+7/2))" );
		System.out.println("InFixToPostfix class result is: " + value);
		
		/**
		 * Manual Trace the evaluation 
		 * showing the operand stack each time it is
		 * modified
		 */
		
		System.out.println("Unbalenced Parethesis Error ");
	}

}
