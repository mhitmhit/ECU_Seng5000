package KW.CH07;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class DemoNavigableSet {

    /*<listing chapter="7" number="12">*/
    public static void main(String[] args) {
        NavigableSet<Integer> odds = new TreeSet<>(List.of(5, 3, 7, 1, 9));
        System.out.println("The original set odds is " + odds);
        NavigableSet<Integer> b = odds.subSet(1, false, 7, true);
        System.out.println("The ordered set b is " + b);
        System.out.println("Its first element is " + b.first());
        System.out.println("Its smallest element >= 6 is " + b.ceiling(6));
    }
    /*</listing>*/
}
