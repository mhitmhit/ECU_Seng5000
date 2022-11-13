package KW.CH06;
/*<listing chapter="6" number="3">*/

import java.util.Scanner;
import java.util.function.BinaryOperator;

public class TestBunaryOperator {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Enter 2 integers: ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        BinaryOperator<Integer> bO = (x, y) -> {
            if (x > y) {
                return x;
            }
            return y;
        };
        
        System.out.println("The larger number is : " + bO.apply(m, n));
    }

}
/*</listing>*/

