package KW.CH08;
/*<exercuse chapter="8" type="ReviewQuestion" number="2">*/
/**
 * Insertion Sort using recursion.
 * @author Koffman &amp; Wolfgang
 */
public class RecursiveInsertionSort implements SortAlgorithm {
    /**
     * Sort the table using insertion sort algorithm.
     * pretable contains Comparable objects.
     * posttable is sorted.
     * @param table The array to be sorted
     */
    @Override
    public <T extends Comparable<T>>  void sort(T[] table) {
        sort(table, 1);
    }
    
    public <T extends Comparable<T>> void sort(T[] table, int nextPos) {
        if (nextPos == table.length) return;
        // Invariant: table[0 . . . nextPos - 1] is sorted.
        // Insert element at position nextPos
        // in the sorted subarray.
        insert(table, nextPos);
        sort(table, nextPos+1);
    } // End sort.

    /**
     * Insert the element at nextPos where it belongs
     * in the array.
     * pretable[0 . . . nextPos - 1] is sorted.
     * posttable[0 . . . nextPos] is sorted.
     * @param table The array being sorted
     * @param nextPos The position of the element to insert
     */
    private static <T extends Comparable<T>>  void insert(T[] table,
            int nextPos) {
        insert(table, nextPos, table[nextPos]);
    }
    
    private static <T extends Comparable<T>> void insert(T[] table, int nextPos, T nextVal) {
        if (nextPos == 0 || nextVal.compareTo(table[nextPos-1]) >= 0) {
            table[nextPos] = nextVal;
            return;
        }
        table[nextPos] = table[nextPos - 1]; // Shift down.
        insert(table, nextPos-1, nextVal);
    }        
}
/*</exercise>*/
