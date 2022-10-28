/*<listing chapter="4" number="9">*/
package A4_Q2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Translates an infix expression with parentheses to a postfix expression.
 * @author Koffman and Wolfgang
 */
public class InfixToPostfixParens {

    // Allow only static methods to construct InfixToPostfixParens object.
    private InfixToPostfixParens() {
    }

    // Insert nested class SyntaxError here. See Listing 4.6.
    /** Class to report a syntax error. */
    @SuppressWarnings("serial")
    public static class SyntaxErrorException
            extends RuntimeException {

        /**
         * Construct a SyntaxErrorException with the specified message.
         * @param message The message
         */
        SyntaxErrorException(String message) {
            super(message);
        }
    }
    // Data Fields
    /** The operators. */
    private static final String OPERATORS = "-+*/()";
    /** The precedence of the operators, matches order of OPERATORS. */
    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
    /** The Pattern to extract tokens.
     *  A token is either a number, an identifier, or an operator
     */
    private static final String PATTERN =
            "\\d+\\.\\d*|\\d+|\\p{L}[\\p{L}\\p{N}]*|[" + OPERATORS + "]";
    /** The stack of characters. */
    private final Deque<Character> operatorStack = new ArrayDeque<>();
    /** The postfix string. */
    private final StringJoiner postfix = new StringJoiner(" ");

    /**
     * Convert a string from infix to postfix.
     * @param infix The infix expression
     * @throws SyntaxErrorException if a syntax error is detected
     * @return the equivalent postfix expression.
     */
    public static String convert(String infix) {
        InfixToPostfixParens infixToPostfixParens = new InfixToPostfixParens();
        infixToPostfixParens.convertToPostfix(infix);
        return infixToPostfixParens.getPostfix();
    }

    /**
     * Return the final postfix string.
     * @return The final postfix string
     */
    public String getPostfix() {
        return postfix.toString();
    }

    /**
     * Convert a string from infix to postfix. 
     * Uses a stack to convert an infix expression to postfix
     * pre: operator stack is empty
     * post: postFix contains postfix expression and stack is empty
     * @param infix the string to convert to postfix
     * @throws SyntaxErrorException if argument is invalid
     */
    public void convertToPostfix(String infix) {
        var scan = new Scanner(infix);
        String nextToken;
        while ((nextToken = scan.findInLine(PATTERN)) != null) {
            char firstChar = nextToken.charAt(0);
            // Is it an operand?
            if (Character.isLetter(firstChar)
                    || Character.isDigit(firstChar)) {
                postfix.add(nextToken);
            } // Is it an operator?
            else if (isOperator(firstChar)) {
                processOperator(firstChar);
            } else {
                throw new SyntaxErrorException(
                        "Unexpected Character Encountered: " + firstChar);
            }
        } // End while.
        // Pop any remaining operators
        // and append them to postfix.
        while (!operatorStack.isEmpty()) {
            char op = operatorStack.pop();
            // Any '(' on the stack is not matched.
            if (op == '(') {
                throw new SyntaxErrorException(
                        "Unmatched opening parenthesis");
            }
            postfix.add(Character.toString(op));
        }
        // assert: Stack is empty, result is in postfix.
    }

    /**
     * Method to process operators.
     * @param op The operator
     * @throws SyntaxErrorException
     */
    private void processOperator(char op) {
        if (operatorStack.isEmpty() || op == '(') {
            operatorStack.push(op);
        } else {
            // Peek the operator stack and
            // let topOp be the top operator.
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
            } else {
                // Pop all stacked operators with equal
                // or higher precedence than op.
                boolean foundLeftParen = false;
                while (!operatorStack.isEmpty()
                        && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    if (topOp == '(') {
                        // Matching '(' popped - exit loop.
                        foundLeftParen = true;
                        break;
                    }
                    postfix.add(Character.toString(topOp));
                    if (!operatorStack.isEmpty()) {
                        // Reset topOp.
                        topOp = operatorStack.peek();
                    }
                }
                // assert: Operator stack is empty or
                //         current operator precedence >
                //         top of stack operator precedence
                //         or found a left parentheses
                if (op != ')') {
                    operatorStack.push(op);
                } else if (!foundLeftParen) {
                    throw new SyntaxErrorException("Un-matched Right Paren");
                }
            }
        }
    }

    /**
     * Determine whether a character is an operator.
     * @param ch The character to be tested
     * @return true if ch is an operator
     */
    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    /**
     * Determine the precedence of an operator.
     * @param op The operator
     * @return the precedence
     */
    private static int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }
}
/*</listing>*/
