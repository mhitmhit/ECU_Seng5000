package KW.CH08;

import java.util.ArrayList;
import java.util.List;

/**
 * A simplified version of the Timsort algorithm. This version includes the
 * solution to the exercises.
 *
 * @author Koffman and Wolfgang
 */
public class TimSort2 implements SortAlgorithm {

// Insert solution to programming exercise 1, section 7, chapter 08 here

    /**
     * Private inner class to hold definitions of the runs
     */
    private static class Run {

        int startIndex;
        int length;

        Run(int startIndex, int length) {
            this.startIndex = startIndex;
            this.length = length;
        }

// Insert solution to programming exercise 1, section 7, chapter 08 here
    }

    /**
     * Array of runs that are pending merging.
     */
    private List<Run> runStack;

    /**
     * Sort the array using the Timsort algorithm.
     *
     * pre: table contains Comparable objects. post: table is sorted.
     *
     * @param table The array to be sorted
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T extends Comparable<T>> void sort(T[] table) {
        runStack = new ArrayList<>();
        int nRemaining = table.length;
        if (nRemaining < 2) {
            return; // Single item array is already sorted.
        }
        int lo = 0;
        do {
            int runLength = nextRun(table, lo);
            runStack.add(new Run(lo, runLength));
            mergeCollapse(table);
            lo += runLength;
            nRemaining -= runLength;
        } while (nRemaining != 0);
        mergeForce(table);
    }

    /**
     * Method to find the length of the next run. A run is a sequence of
     * ascending items such that a[i] &amp;lt;= a[i+1] or descending items such
     * that a[i] &amp;gt; a[i+1]. If a descending sequence is found, it is
     * turned into an ascending sequence.
     *
     * @param table The table being sorted
     * @param lo The index where the sequence starts
     * @return the length of the sequence.
     */
    private <T extends Comparable<T>> int nextRun(T[] table, int lo) {
        if (lo == table.length - 1) {
            return 1;
        }
        int hi = lo + 1;
        if (table[hi - 1].compareTo(table[hi]) <= 0) {
            while (hi < table.length && table[hi - 1].compareTo(table[hi]) <= 0) {
                hi++;
            }
        } else {
            while (hi < table.length && table[hi - 1].compareTo(table[hi]) > 0) {
                hi++;
            }
            swapRun(table, lo, hi - 1);
        }
        return hi - lo;
    }

    /**
     * Method to convert a descending sequence into an ascending sequence.
     *
     * @param table The table being sorted
     * @param lo The start index
     * @param hi The end index
     */
    private <T extends Comparable<T>> void swapRun(T[] table, int lo, int hi) {
        while (lo < hi) {
            swap(table, lo++, hi--);
        }
    }

    /**
     * Swap the items in table[i] and table[j].
     *
     * @param table The array that contains the items
     * @param i The index of one item
     * @param j The index of the other item
     */
    private <T extends Comparable<T>> void swap(T[] table, int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

    /**
     * Merge adjacent runs until the following invariant is established. 1.
     * runLength[top - 2] &gt; runLenght[top - 1] + runLength[top] 2.
     * runLength[top - 1] &gt; runLength[top] This method is called each time a
     * new run is added to the stack. Invariant is true before a new run is
     * added to the stack.
     */
    private <T extends Comparable<T>> void mergeCollapse(T[] table) {
        while (runStack.size() > 1) {
            int top = runStack.size() - 1;
            if (top > 1 && runStack.get(top - 2).length
                    <= runStack.get(top - 1).length + runStack.get(top).length) {
                if (runStack.get(top - 2).length < runStack.get(top).length) {
                    mergeAt(table, top - 2);
                } else {
                    mergeAt(table, top - 1);
                }
            } else if (runStack.get(top - 1).length <= runStack.get(top).length) {
                mergeAt(table, top - 1);
            } else {
                break;
            }
// Insert solution to programming exercise 1, section 7, chapter 08 here
        }
    }

    /**
     * Merge all remaining runs. This method is called to complete the sort.
     */
    private <T extends Comparable<T>> void mergeForce(T[] table) {
        while (runStack.size() > 1) {
            int top = runStack.size() - 1;
            if (top > 1 && runStack.get(top - 2).length < runStack.get(top).length) {
                mergeAt(table, top - 2);
            } else {
                mergeAt(table, top - 1);
            }
        }
    }

    /**
     * Merge the two adjacent runs at i and i+1. i must be equal to
     * runStack.size() - 2 or runStack.size() - 3.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private <T extends Comparable<T>> void mergeAt(T[] table, int i) {
        int base1 = runStack.get(i).startIndex;
        int len1 = runStack.get(i).length;
        int base2 = runStack.get(i + 1).startIndex;
        int len2 = runStack.get(i + 1).length;
        runStack.set(i, new Run(base1, len1 + len2));
        if (i == runStack.size() - 3) {
            runStack.set(i + 1, runStack.get(i + 2));
        }
        runStack.remove(runStack.size() - 1);
// Insert solution to programming exercise 2, section 7, chapter 08 here
                T[] run1 = (T[]) (new Comparable[len1]);
                T[] run2 = (T[]) (new Comparable[len2]);
                System.arraycopy(table, base1, run1, 0, len1);
                System.arraycopy(table, base2, run2, 0, len2);
                merge(table,newBase1, run1, run2);
// Insert solution to programming exercise 2, section 7, chapter 08 here
    }

// Insert solution to programming exercise 1, section 7, chapter 08 here

// Insert solution to programming exercise 2, section 7, chapter 08 here
    /**
     * Merge two runs into the table
     *
     * @param destIndex Index where the merged run is to be inserted
     * @param run1 Array containing one run
     * @param run2 Array containing the other run
     */
    private <T extends Comparable<T>> void merge(T[] table, int destIndex, T[] run1, T[] run2) {
        int i = 0;
        int j = 0;
        while (i < run1.length && j < run2.length) {
            if (run1[i].compareTo(run2[j]) < 0) {
                table[destIndex++] = run1[i++];
            } else {
                table[destIndex++] = run2[j++];
            }
        }
        while (i < run1.length) {
            table[destIndex++] = run1[i++];
        }
        while (j < run2.length) {
            table[destIndex++] = run2[j++];
        }
    }

}
/*</listing>*/
