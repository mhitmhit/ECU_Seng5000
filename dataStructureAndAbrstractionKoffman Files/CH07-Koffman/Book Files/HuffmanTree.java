/*<listing chapter="7" section="6">*/
package KW.CH07;

import KW.CH06.BinaryTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to represent and build a Huffman tree
 * @author Koffman and Wolfgang */
public class HuffmanTree extends KW.CH06.HuffmanTree {

    /** The map between Characters and their coding */
    Map<Character, BitString> codeMap;

    // Methods

    /*<listing chapter="7" number="12">*/
    public static HuffData[] buildFreqTable(BufferedReader ins) {
        // Map of frequencies.
        Map<Character, Integer> frequencies = new HashMap<>();  
        try (ins) {
            int nextChar;   // For storing the next character as an int
            while ((nextChar = ins.read()) != -1) {  // Test for more data
                Character next = (char)nextChar;
                // Get the current count and increment it.
                Integer count = frequencies.get(next);
                if (count == null) {
                    count = 1;   // First occurrence.
                } else {
                    count++;
                }
                // Store updated count.
                frequencies.put(next, count);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        // Copy Map entries to a HuffData[] array.
        HuffData[] freqTable = new HuffData[frequencies.size()];
        int i = 0;     // Start at beginning of array.
        // Get each map entry and store it in the array 
        // as a weight-symbol pair.
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            freqTable[i] =
                    new HuffData(entry.getValue().doubleValue(),
                    entry.getKey());
            i++;
        }
        return freqTable;    // Return the array.
    }
    /*</listing>*/

    /**
     * Starter method to build the code table.
     * postThe table is built.
     */
    public void buildCodeTable() {
        // Initialzie the code map
        codeMap = new HashMap<>();
        // Call recursive method with empty bit string for code so far.
        buildCodeTable(huffTree, new BitString());
    }

    /**
     * Recursive method to perform breadth-first traversal
     * of the Huffman tree and build the code table.
     * @param tree The current tree root
     * @param code The code string so far
     */
    private void buildCodeTable(BinaryTree<HuffData> tree, BitString code) {
        // Get data at local root.
        HuffData datum = tree.getData();
        if (datum.getSymbol() != '\u0000') {  // Test for leaf node.
            // Found a symbol, insert its code in the map.
            codeMap.put(datum.getSymbol(), code);
        } else {
            // Append 0 to code so far and traverse left. 
            BitString leftCode = code.append(false);
            buildCodeTable(tree.getLeftSubtree(), leftCode);
            // Append 1 to code so far and traverse right.
            BitString rightCode = code.append(true);
            buildCodeTable(tree.getRightSubtree(), rightCode);
        }
    }

    /**
     * Encodes a data file by writing it in compressed bit string form.
     * @param ins The input stream
     * @param outs The output stream
     * @return The length of the encoded BitString
     */
    public int encode(BufferedReader ins,
            OutputStream outs) {
        BitStringBuilder result = new BitStringBuilder();  // The complete bit string.
        try (ins; outs) {
            int nextChar;
            while ((nextChar = ins.read()) != -1) {  // More data?
                Character next = (char) nextChar;

                // Get bit string corresponding to symbol nextChar.
                BitString nextChunk = codeMap.get(next);
                result = result.append(nextChunk);   // Append to result string.
            }
            // Write result to output file and close files.
            result.toBitString().writeToStream(outs);
            return result.size();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

// Insert solution to programming project 1, chapter 07 here
}
/*</listing>*/
