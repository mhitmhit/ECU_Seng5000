package KW.CH03;
/** This class computes the sin and cos of an angle 
 *  expressed in degrees. The result will be an
 *  an integer representing the sin or cos as 
 *  ten-thousandths.
 *  @author Koffman and Wolfgang
 */
public class SinCos {
    /** Compute the sin of an angle in degrees
     *  @param x - The angle in degrees
     *  @return the sin of x
     */
    public static int sin(int x) {
        if (x < 0) {
            x = -x;
        }
        x = x % 360;
        if (0 <= x && x <= 45) {
            return sin0to45(x);
        } else if (45 <= x && x <= 90) {
            return sin45to90(x);
        } else if (90 <= x && x <= 180) {
            return sin(180 - x);
        } else {
            return -sin(x - 180);
        }
    }
    
    /** Compute the cos of an angle in degrees
     * @param x - The angle in degrees
     * @return the cos of x
     */
    public static int cos(int x) {
        return sin(x + 90);
    }
    
    /** Compute the sin of an angle in degrees
     *  between 0 and 45
     *  @param x - The angle
     *  @return the sin of x
     *  Precondition: 0 &lt;= x &lt; 45
     */
    private static int sin0to45(int x) {
        /* In a realistic program this method would
         * use a polynomial approximation that was
         * optimized for the input range
         */
        return (int)Math.round(Math.sin(Math.toRadians(x))*10000);
    }
    
    /** Compute the sin of an angle in degrees
     *  between 45 and 90
     *  @param x - The angle
     *  @return the sin of x
     *  Precondition: 45 &lt;= x &lt;= 90
     */
    private static int sin45to90(int x) {
        /* In a realistic program this method would
         * use a polynomial approximation that was
         * optimized for the input range
         */
        return (int)Math.round(Math.sin(Math.toRadians(x))*10000);
    }

}
