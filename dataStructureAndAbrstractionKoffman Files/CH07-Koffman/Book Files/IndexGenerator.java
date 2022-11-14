package KW.CH07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * Class to build an index.
 *  @author Koffman and Wolfgang
 **/
public class IndexGenerator {
    
    private static final Pattern WORD_PATTERN = 
            Pattern.compile("[\\p{L}\\p{N}']+");

    // Data Fields
    /** Tree for storing the index. */
    private final SortedMap<String, List<Integer>> index;

    // Methods
    public IndexGenerator() {
        index = new TreeMap<>();
    }

    /*<listing chapter="7" number="2">*/
    /**
     * Reads each word in data file and stores it in a Map
     * along with an ArrayList of line numbers (a value).
     * preindex in an empty Map.
     * postLowercase form of each word with line
     *       numbers is stored in index.
     * @param scan A Scanner object
     */
    public void buildIndex(Scanner scan) {
        int lineNum = 0; // Line number
        // Keep reading lines until done.
        while (scan.hasNextLine()) {
            lineNum++;
            // Extract each token and store it in index.
            String token;
            while ((token = scan.findInLine(WORD_PATTERN)) != null) {
                token = token.toLowerCase();
                var lines = index.getOrDefault(token, new ArrayList<>());
                lines.add(lineNum);
                index.put(token, lines);  //Store new list
            }
            scan.nextLine();
        }
    }
    /*</listing>*/

// Insert solution to programming exercise 4, section 5, chapter 07 here

    public static void main(String args[]) {
        if (args.length < 1) {
            System.err.println("Usage: IndexGenerator <file>");
            System.exit(1);
        }
        try (Scanner scan = new Scanner(new FileReader(args[0]))) {           
            IndexGenerator indexGenerator = new IndexGenerator();
            indexGenerator.buildIndex(scan);
            indexGenerator.showIndex();
        } catch (FileNotFoundException ioex) {
            System.err.println("Cannot open file " + args[0]);
            System.exit(1);
        }
    }
}
