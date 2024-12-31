import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class InsertionSort {

    /* Insertion Sort is a sorting algorithm that builds the sorted list one element at a time, from left to right.
     * It works by repeatedly taking an element from the unsorted portion,
     * and inserting it into its correct position in the sorted portion of the list. */

    public List<List<KVPair>> insertionSort(List<KVPair> list) {
        if (list == null) throw new IllegalArgumentException("insertionSort(): list shouldn't be null");
        List<List<KVPair>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                // stable
                if (list.get(j).key >= list.get(j - 1).key) break;
                swap(list, j, j - 1);
            }
            // track intermediate states
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public static class KVPair {
        private int key;
        private String value;
    }

    private static <T> void swap(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
