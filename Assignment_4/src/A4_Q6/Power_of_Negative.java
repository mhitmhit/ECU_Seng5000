package A4_Q6;

public class Power_of_Negative {

	/**
     * Recursive power method (in RecursiveMethods.java).
     * pre: n &gt;= 0
     * evaluates sign of n,
     * 	if pos - x * power(x, n-1)
     *  if neg - (1/x) * power(x, n+1)
     * @param x The number being raised to a power
     * @param n The exponent
     * @return x raised to the power n
     */
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return x * power(x, n - 1);
        } else{
        	return (1/x) * power(x, n + 1);
        }
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(2, -3)); // expecting 0.125
		System.out.println(power(2, -2)); // expecting 0.25
		System.out.println(power(2, 0)); // expecting 1
		System.out.println(power(2, 3)); // expecting 8
	    
	    
	}
}
