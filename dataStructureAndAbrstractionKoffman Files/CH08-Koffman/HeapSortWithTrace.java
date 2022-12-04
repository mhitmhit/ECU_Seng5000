package KW.CH08;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 *
 * @author Koffman &amp; Paul
 */
public class HeapSortWithTrace {
    /**
     * Sort the array using heap sort algorithm.pre: table contains Comparable items.
     * post: table is sorted.
     * @param <T> The data type
     * @param table The array to be sorted
     */
    public <T extends Comparable<T>>  void sort(T[] table) {
        buildHeap(table);

        shrinkHeap(table);
    }

    /**
     * buildHeap transforms the table into a heap.
     * preThe array contains at least one item.
     * postAll items in the array are in heap order.
     * @param table The array to be transformed into a heap
     */
    private <T extends Comparable<T>>  void buildHeap(T[] table) {
        int n = 1;

        // Invariant: table[0 . . . n - 1] is a heap.
        while (n < table.length) {
            n++; // Add a new item to the heap and reheap.
            int child = n - 1;
            int parent = (child - 1) / 2; // Find parent.
            while (parent >= 0
                    && table[parent].compareTo(table[child]) < 0) {
                swap(table, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
            printArray(table);
        }
    }

    /**
     * shrinkHeap transforms a heap into a sorted array.
     * prell items in the array are in heap order.
     * postThe array is sorted.
     * @param table The array to be sorted
     */
    private <T extends Comparable<T>>  void shrinkHeap(T[] table) {
        int n = table.length;

        // Invariant: table[0 . . . n - 1] forms a heap.
        // table[n . . . table.length - 1] is sorted.
        while (n > 0) {
            n--;
            swap(table, 0, n);
            // table[1 . . . n - 1] form a heap.
            // table[n . . . table.length - 1] is sorted.
            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break; // No more children.
                }
                int rightChild = leftChild + 1;
                // Find the larger of the two children.
                int maxChild = leftChild;
                if (rightChild < n // There is a right child.
                        && table[leftChild].compareTo(table[rightChild]) < 0) {
                    maxChild = rightChild;
                }
                // If the parent is smaller than the larger child,
                if (table[parent].compareTo(table[maxChild]) < 0) {
                    // Swap the parent and child.
                    swap(table, parent, maxChild);
                    // Continue at the child level.
                    parent = maxChild;
                } else { // Heap property is restored.
                    break; // Exit the loop.
                }
            }
            printArray(table);
        }
    }

    /**
     * Swap the items in table[i] and table[j].
     * @param table The array that contains the items
     * @param i The index of one item
     * @param j The index of the other item
     */
    private static <T extends Comparable<T>>  void swap(T[] table,
            int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
    
    private static <T> void printArray(T[] array) {
        var stb = new StringJoiner(" ");
        for (T array1 : array) {
            stb.add(String.format("%3s", array1.toString()));
        }
        System.out.println(stb.toString());
    }

    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (String s : args) {
            list.add(Integer.decode(s));
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        (new HeapSortWithTrace()).sort(array);
    }
}
