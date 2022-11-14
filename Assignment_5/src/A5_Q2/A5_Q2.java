package A5_Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Class to build an index.
 * @author Koffman and Wolfgang
 */

public class A5_Q2 {

    // Data Fields
    /**
     * Tree for storing the index.
     */
    private final TreeSet<Object> index;
    /**
     * Pattern for extracting words from a line A word is a string of one or
     * more letters or numbers or ' characters
     */
    private static final String PATTERN = "[\\p{L}\\p{N}']+";

    // Methods
    public A5_Q2() {
        index = new TreeSet<>();
    }

    /**
     * Reads each word in file referenced by Scanner scan and stores it in 
     * search tree along with its line number.
     *
     * @post Lowercase form of each word with line number stored in index.
     * @param scan A Scanner object that contains the input text
     */
    public void buildIndex(Scanner scan) {
        int lineNum = 0; // Line number
        // Keep reading lines until done.
        while (scan.hasNextLine()) {
            lineNum++;
            // Extract each token and store it in index
            String token;
            while ((token = scan.findInLine(PATTERN)) != null) {
                token = token.toLowerCase();
                index.add(String.format("%s, %3d", token, lineNum));
            }
            try {
            	scan.nextLine();
            }catch(Exception e) {
            	return;
            }
        }
    }

    /**
     * Displays the index, one word per line.
     */
    public void showIndex() {
        // Use an iterator to access and display tree data.
        index.forEach(next -> System.out.println(next));
    }

    /**
     * Reads each word in file referenced by Scanner scan and stores it in 
     * search tree along with its line number.
     * Scan a *.txt file saved to Desktop.
     */

public static void main(String[] args) {
    Scanner scan = null;
    try { //scan a text file saved to desktop 
        scan = new Scanner(new FileReader(new File("C:\\Users\\YE\\Desktop\\test.txt")));
    } 
    catch (IOException ex) {
        System.err.println("Error opening file " + "C:\\Users\\YE\\Desktop\\test.txt");
        ex.printStackTrace();
        System.exit(1);
    }
    A5_Q2 indexGenerator = new A5_Q2(); //Build index for scanner object location
    indexGenerator.buildIndex(scan); //Reference object from *.txt file as stored in search tree location
    indexGenerator.showIndex(); // print index one word per line
}
}
