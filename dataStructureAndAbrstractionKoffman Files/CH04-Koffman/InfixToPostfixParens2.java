package KW.CH04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.StringJoiner;

/** Translates an infix expression with parentheses
 *  to a postfix expression. Modified to include programming exercise
 *  and programming project solutions.
 *  @author Koffman &amp; Wolfgang
 */
public class InfixToPostfixParens2 {
    
    private InfixToPostfixParens2() {}

    // Nested Class
    /** Class to report a syntax error. */
    @SuppressWarnings("serial")
    public static class SyntaxErrorException
            extends RuntimeException {

        /**
         * Construct a SyntaxErrorException with the specified
         * message.
         * @param message The message
         */
        SyntaxErrorException(String message) {
            super(message);
        }
    }
    // Data Fields
    /** The operators */
//    private static final String OPERATORS = "-+*/()";
// Insert solution to programming project 2, chapter 04 here
    /**
     * The Pattern to extract tokens
     * A token is either a string of digits (\d+)
     * or a JavaIdentifier
     * or an operator
     */
    private static final String PATTERN =
//            "\\d+\\.\\d*|\\d+|\\p{L}[\\p{L}\\p{N}]*|[" + OPERATORS + "]";
// Insert solution to programming project 2, chapter 04 here
    /** The precedence of the operators, matches order of OPERATORS. */
//    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
// Insert solution to programming project 2, chapter 04 here
    
    /** The postfix string */

    /**
     * Convert a string from infix to postfix.
     * @param infix The infix expression
     * @return The string converted to postfix
     * @throws SyntaxErrorException if a syntax error is detected
     */
    public static String convert(String infix) {
        Deque<Character> operatorStack = new ArrayDeque<>();
        StringJoiner postfix = new StringJoiner(" ");
        var scan = new Scanner(infix);
// Insert solution to programming exercise 2, section 4, chapter 04 here
        try {
            // Process each token in the infix string.
            String nextToken;
            while ((nextToken = scan.findInLine(PATTERN)) != null) {
                char firstChar = nextToken.charAt(0);
                // Is it an operand?
                if (Character.isJavaIdentifierStart(firstChar)
                        || Character.isDigit(firstChar)) {
// Insert solution to programming exercise 2, section 4, chapter 04 here
                    postfix.add(nextToken);
                } // Is it an operator?
                else if (isOperator(firstChar)) {
// Insert solution to programming exercise 2, section 4, chapter 04 here
                    processOperator(firstChar, operatorStack, postfix);
                } else {
                    throw new SyntaxErrorException("Unexpected Character Encountered: "
                            + firstChar);
                }
            } // End while.
// Insert solution to programming exercise 2, section 4, chapter 04 here
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
            // assert: Stack is empty, return result.
            return postfix.toString();
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    /**
     * Method to process operators.
     * @param op The operator
     * @throws EmptyStackException
     */
    private static void processOperator(char op, Deque<Character> operatorStack, 
            StringJoiner postfix) {
        if (operatorStack.isEmpty() || isLeftParen(op)) {
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
                while (!operatorStack.isEmpty()
                        && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    if (isLeftParen(topOp)) {
                        if (isMatchingParen(topOp, op)) {
                            break;
                        } else {
                            throw new SyntaxErrorException(Character.toString(topOp) 
                            + " does not match " + Character.toString(op));
                        }
                    }
                    postfix.add(Character.toString(topOp));
                    if (!operatorStack.isEmpty()) {
                        // Reset topOp.
                        topOp = operatorStack.peek();
                    }
                }

                // assert: Operator stack is empty or
                //         current operator precedence >
                //         top of stack operator precedence.
                if (!isRightParen(op)) {
                    operatorStack.push(op);
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
    
    private static boolean isLeftParen(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    private static boolean isRightParen(char c) {
        return c == ')' || c == ']' || c == '}';
    }
    
    private static boolean isMatchingParen(char c1, char c2) {
        return (c1 == '(' && c2 == ')')
                || (c1 == '[' && c2 == ']')
                || (c1 == '{' && c2 == '}');
        
    }
}
