/*<listing chapter="5" number="2">*/
package KW.CH05;

import java.util.Scanner;

/** Class that solves Towers of Hanoi problem.
 *  @author Koffman and Wolfgang
 **/
public class TowersOfHanoi {

    /**
     * Recursive method for &quot;moving&quot; disks.
     * pretartPeg, destPeg, tempPeg are different.
     * @param n is the number of disks
     * @param startPeg is the starting peg
     * @param destPeg is the destination peg
     * @param tempPeg is the temporary peg
     * @return A string with all the required disk moves
     */
    public static String showMoves(int n, char startPeg,
            char destPeg, char tempPeg) {
        if (n == 1) {
            return "Move disk 1 from peg " + startPeg
                    + " to peg " + destPeg + "\n";
        } else { // Recursive step
            return showMoves(n - 1, startPeg, tempPeg, destPeg)
                    + "Move disk " + n + " from peg " + startPeg
                    + " to peg " + destPeg + "\n"
                    + showMoves(n - 1, tempPeg, destPeg, startPeg);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of disks ");
        int nDisks = in.nextInt();
        String moves = showMoves(nDisks, 'L', 'R', 'M');
        System.out.println(moves);
    }
}
/*</listing>*/
