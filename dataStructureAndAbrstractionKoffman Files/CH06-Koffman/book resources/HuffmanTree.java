/*<listing chapter="6" number="9">*/
package KW.CH06;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Class to represent and build a Huffman tree.
 *
 * @author Koffman and Wolfgang
 *
 */
public class HuffmanTree {

    // Nested Classes
    /**
     * A datum in the Huffman tree.
     */
    public static class HuffData {
        // Data Fields

        /**
         * The weight or probability assigned to this HuffData.
         */
        private final double weight;
        /**
         * The alphabet symbol if this is a leaf.
         */
        private final char symbol;

        public HuffData(double weight, char symbol) {
            this.weight = weight;
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() == o.getClass()) {
                HuffData other = (HuffData)o;
                return weight == other.weight && symbol == other.symbol;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
            hash = 97 * hash + this.symbol;
            return hash;
        }
        
        @Override
        public String toString() {
            return String.format("'%s': %f", Character.toString(symbol), weight);
        }
    }
    // Data Fields
    /**
     * A reference to the completed Huffman tree.
     */
    protected BinaryTree<HuffData> huffTree;

    /*<listing chapter="6" number="10">*/
    /**
     * Builds the Huffman tree using the given alphabet and weights.
     *
     * posthuffTree contains a reference to the Huffman tree.
     * @param symbols An array of HuffData objects
     */
    public void buildTree(HuffData[] symbols) {
        Queue<BinaryTree<HuffData>> theQueue
                = new PriorityQueue<>((lt, rt) -> 
                     Double.compare(lt.getData().weight, rt.getData().weight)
                );
        // Load the queue with the leaves.
        for (HuffData nextSymbol : symbols) {
            var aBinaryTree = new BinaryTree<>(nextSymbol, null, null);
            theQueue.offer(aBinaryTree);
        }

        // Build the tree.
        while (theQueue.size() > 1) {
            var left = theQueue.poll();
            var right = theQueue.poll();
            double wl = left.getData().weight;
            double wr = right.getData().weight;
            var sum = new HuffData(wl + wr, '\u0000');
            var newTree = new BinaryTree<>(sum, left, right);
            theQueue.offer(newTree);
        }

        // The queue should now contain only one item.
        huffTree = theQueue.poll();
    }
    /*</listing>*/

    /**
     * Outputs the resulting code.
     *
     * @param out A PrintStream to write the output to
     * @param code The code up to this node
     * @param tree The current node in the tree
     */
    private void printCode(PrintStream out, String code,
            BinaryTree<HuffData> tree) {
        HuffData theData = tree.getData();
        if (theData.symbol != '\u0000') {
            if (theData.symbol == ' ') {
                out.println("space: " + code);
            } else {
                out.println(theData.symbol + ": " + code);
            }
        } else {
            printCode(out, code + "0", tree.getLeftSubtree());
            printCode(out, code + "1", tree.getRightSubtree());
        }
    }

    /**
     * Outputs the resulting code.
     *
     * @param out A PrintStream to write the output to
     */
    public void printCode(PrintStream out) {
        printCode(out, "", huffTree);
    }

    /*<listing chapter="6" number="11">*/
    /**
     * Method to decode a message that is input as a string of digit characters
     * '0' and '1'.
     *
     * @param codedMessage The input message as a String of zeros and ones.
     * @return The decoded message as a String
     */
    public String decode(String codedMessage) {
        StringBuilder result = new StringBuilder();
        var currentTree = huffTree;
        for (int i = 0; i < codedMessage.length(); i++) {
            if (codedMessage.charAt(i) == '1') {
                currentTree = currentTree.getRightSubtree();
            } else {
                currentTree = currentTree.getLeftSubtree();
            }
            if (currentTree.isLeaf()) {
                HuffData theData = currentTree.getData();
                result.append(theData.symbol);
                currentTree = huffTree;
            }
        }
        return result.toString();
    }
    /*</listing>*/

// Insert solution to programming exercise 1, section 7, chapter 06 here
    
// Insert solution to programming project 2, chapter 06 here
}
/*</listing>*/
