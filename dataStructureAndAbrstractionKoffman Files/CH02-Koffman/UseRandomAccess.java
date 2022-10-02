package KW.CH02;

import java.util.RandomAccess;
import java.util.List;
import java.util.ArrayList;

public class UseRandomAccess {

    public static <E> void someMethod(List<E> aList) {
        List<E> workingCopy = aList;
        if (!(aList instanceof RandomAccess)) {
            workingCopy = new ArrayList<>(aList);
        }
        // Perform random access work on working copy
        // Copy working copy back into linked list.
        if (!(aList instanceof RandomAccess)) {
            aList.clear();
            aList.addAll(workingCopy);
        }
    }
}
