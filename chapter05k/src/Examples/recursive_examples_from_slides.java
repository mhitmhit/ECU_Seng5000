package Examples;

public class recursive_examples_from_slides {
	/** Recursive method length
    	@param str The string
    	@return The length of the string
	*/
	public static int length(String str) {
		  if (str == null || str.equals(""))
		  return 0;
		else
		  return 1 + length(str.substring(1));
		}
	
	/**
	 * factorial calucation using recursion
	 * @param n
	 * @return
	 */
	public static int factorial(int n) {
		  if (n == 0) 
		    return 1;
		  else
		    return n * factorial(n - 1);
		}
	
	
	/** Recursive power method (in RecursiveMethods.java).
    pre: n >= 0
    @param x The number being raised to a power
    @param n The exponent
    @return x raised to the power n
	*/
	public static double power(double x, int n) {
	    if (n == 0)
		 return 1;
	    else
		 return x * power(x, n - 1);
	}


	/** Recursive gcd method (in RecursiveMethods.java).
    pre: m > 0 and n > 0
    @param m The larger number
    @param n The smaller number
    @return Greatest common divisor of m and n
	*/
	public static double gcd(int m, int n) {
	    if (m % n == 0)
		 return n;
	    else
		 return gcd(n, m % n);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(length("test"));
		System.out.println(factorial(5));
	}

}
