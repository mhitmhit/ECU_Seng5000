package KW.CH07;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {

// Insert solution to programming exercise 1, section 2, chapter 07 here

// Insert solution to programming exercise 2, section 2, chapter 07 here

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new FileReader(args[0]));
            buildWordCounts(scan);
            COUNTS.forEach((k, v) -> System.out.printf("%-15s%5d%n", k, v));
        } catch (FileNotFoundException ex) {
            System.err.println(args[0] + " not found");
        }
    }
}
