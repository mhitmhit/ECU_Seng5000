package KW.CH03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to demonstrate use of debugger
 *
 * @author Koffman and Wolfgang
 */
public class FillArray {

// Insert solution to programming exercise 1, section 7, chapter 03 here
 /*<listing chapter="3" number="2">*/
    /**
     * Return the individual words entered by the user. The user can enter the
     * sentinel *** to terminate data entry.
     *
     * @return A string with a maximum of 10 words
     */
    public static List<String> getStrings() {
        var in = new Scanner(System.in);
        List<String> stringy = new ArrayList<>();
        int count = 0;
        while (count < 10) {
            System.out.println("Enter a word or *** to quit");
            String word = in.next();
// Insert solution to programming exercise 1, section 7, chapter 03 here
            if (word == "***") {
                break;
            }
            stringy.add(word);
            count++;
        }
        return stringy;
    }

    /*</listing>*/

    public static void main(String[] args) {
        var stringList = getStrings();
        System.out.println("The list of words is " + stringList);
    }

}
