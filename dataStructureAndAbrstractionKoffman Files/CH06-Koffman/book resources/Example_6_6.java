package KW.CH06;

import java.util.function.Function;

public class Example_6_6 {
    /*<example chapter="6" number="6">*/
    /**
     * Displays values associated with function f in the range specified.
     * @param low the lower bound
     * @param high the upper bound
     * @param step the increment
     * @param f the function object
     */
    public static void show(int low, int high, int step, Function<Integer, Double> f) {
        for (int i = low; i <= high; i += step)
            System.out.println(i + " : " + f.apply(i));
    }
    /*</example>*/
    
    public static void main(String[] args) {
        Function<Integer, Double> f;
        f = angle -> Math.cos(Math.toRadians(angle));
        show(0, 360, 30, f);
    }

}
