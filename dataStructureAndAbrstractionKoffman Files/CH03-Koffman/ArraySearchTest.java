package KW.CH03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test of ArraySearch.search
 *
 * @author Koffman and Wolfgang
 */
public class ArraySearchTest {

    // Common array to search for most of the tests
    private final int[] x = {5, 12, 15, 4, 8, 12, 7};

    @Test
    public void firstElementTest() {
        // Test for target as first element.
        assertEquals("5 not at position 0" , 0, ArraySearch.search(x, 5));
    }

    @Test
    public void lastElementTest() {
        // Test for target as last element.
        assertEquals(6, ArraySearch.search(x, 7), "7 not at position 6");
    }

    @Test
    public void inMiddleTest() {
        // Test for target somewhere in middle.
        assertEquals(3, ArraySearch.search(x, 4), "4 is not found at position 3");
    }

    @Test
    public void notInArrayTest() {
        // Test for target not in array.
        assertEquals(-1, ArraySearch.search(x, -5));
    }

    @Test
    public void multipleOccurencesTest() {
        // Test for multiple occurrences of target.
        assertEquals(1, ArraySearch.search(x, 12));
    }

    @Test
    public void oneElementArrayTestItemPresent() {
        // Test for 1-element array
        int[] y = {10};
        assertEquals(0, ArraySearch.search(y, 10));
    }

    @Test
    public void oneElementArrayTestItemAbsent() {
        // Test for 1-element array
        int[] y = {10};
        assertEquals(-1, ArraySearch.search(y, -10));
    }

    @Test
    public void emptyArrayTest() {
        // Test for an empty array
        int[] y = new int[0];
        assertEquals(-1, ArraySearch.search(y, 10));
    }

    @Test
    public void nullArrayTest() {
        int[] y = null;
        assertThrows(NullPointerException.class,
                () -> ArraySearch.search(y, 10));
    }
}
