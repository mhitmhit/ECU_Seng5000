package Examples;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Test Class to MyInput
 * @author Koffman &amp; Wolfgang
 */
public class MyInputTest {
    private static final String NL = System.getProperty("line.separator");

    @Test
    public void testForInvalidInput() {
    	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
    			() -> MyInput.readInt("Enter weight", 5, 2));
    	assertEquals("In readInt, minN 5 not <= maxN 2", ex.getMessage());
    }
    
    @Test
    public void testForNormalInput() {
        var testIn = new ByteArrayInputStream("3".getBytes());
        System.setIn(testIn);
        int n = MyInput.readInt("Enter weight", 2, 5);
        assertEquals(n, 3);
    }
    
    @Test
    public void testThatPromptIsCorrectForNormalInput() {
        var testIn = 
                new ByteArrayInputStream("3".getBytes());
        System.setIn(testIn);
        var testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        int n = MyInput.readInt("Enter weight", 2, 5);
        assertEquals(n, 3);
        var displayedPrompt = testOut.toString();
        var expectedPrompt = "Enter weight" + 
                "\nEnter an integer between 2 and 5" + NL;
        assertEquals(expectedPrompt, displayedPrompt);
    }
    
// Insert solution to programming exercise 2, section 6, chapter 03 here
        
// Insert solution to programming exercise 1, section 6, chapter 03 here

}
    

