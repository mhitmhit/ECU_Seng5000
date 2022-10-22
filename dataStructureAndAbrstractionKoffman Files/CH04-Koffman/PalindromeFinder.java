/*<listing chapter="4" number="2">*/
package KW.CH04;

import java.util.ArrayDeque;
import java.util.Deque;

/** Class with methods to check whether a string is a palindrome.
 *  @author Koffman &amp; Wolfgang
 **/
public class PalindromeFinder {

    /**
     * Private constructor, since this class only contains static methods.
     */
    private PalindromeFinder() {}

    /** Method to fill a stack of characters from an input string. */
    private static Deque<Character> fillStack(String inputString) {
        Deque<Character> charStack = new ArrayDeque<>();
        for (int i = 0; i < inputString.length(); i++) {
            charStack.push(inputString.charAt(i));
        }
        return charStack;
    }

    /**
     * Method to build the reverse of a string by pushing them onto a stack
     * and then building a string containing the characters in a stack.
     * post: The stack is empty.
     * @return The string containing the words in the stack
     */
    private static String buildReverse(String str) {
        Deque<Character> charStack = fillStack(str);
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            // Remove top item from stack and append it to result.
            result.append(charStack.pop());
        }
        return result.toString();
    }

    public static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(buildReverse(str));
    }
    
// Insert solution to programming project 1, chapter 04 here
    
// Insert solution to programming project 6, chapter 04 here
}
/*</listing>*/
