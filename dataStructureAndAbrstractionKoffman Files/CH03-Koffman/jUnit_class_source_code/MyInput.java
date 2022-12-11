/**
 * @author Koffman and Wolfgang
 */
package KW.CH03;

import java.util.Scanner;

public class MyInput {

    /**
     * Method to return an integer data value.
     * @param prompt Message
     * @return The data value read as an int
     */
    public static int readInt(String prompt) {
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println(prompt);
                String numStr = in.next();
                return Integer.parseInt(numStr);
            } catch (NumberFormatException ex) {
                System.out.println("Bad numeric string - Try again");
            }
        }
    }

    /**
     * Method to return an integer data value between two
     * specified end points.
     * @pre minN <= maxN.
     * @param prompt Message
     * @param minN Smallest value in range
     * @param maxN Largest value in range
     * @throws IllegalArgumentException
     * @return The first data value that is in range
     */
    public static int readInt(String prompt, int minN, int maxN) {
        if (minN > maxN) {
            throw new IllegalArgumentException(
                    "In readInt, minN " + minN
                    + " not <= maxN " + maxN);
        }
        // Arguments are valid, read a number
        boolean inRange = false; //Assume no valid number read
        int n = 0;
        Scanner in = new Scanner(System.in);
        while (!inRange) {
            try {
                System.out.println(
                        prompt + "\nEnter an integer between "
                        + minN + " and " + maxN);
                String line = in.nextLine();
                n = Integer.parseInt(line);
                inRange = (minN <= n && n <= maxN);
            } catch (NumberFormatException ex) {
                System.out.println("Bad numbric string - Try again");
            }
        }
        return n;
    }
    /*</listing>*/
}
