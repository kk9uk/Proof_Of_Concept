import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

    /* This is an in-place, randomized, and iterative implementation of Quick Select, by kk9uk. */

    public static int quickSelect(int[] arr, int k) {
        arr = removeDuplicates(arr);

        int l = 0, r = arr.length - 1, pivotI;
        while (l <= r) {
            pivotI = l + new Random().nextInt(r - l + 1);

            swap(arr, pivotI, r);
            pivotI = r;

            int ll = l, rr = r - 1;
            while (ll <= rr) {
                if (arr[ll] < arr[pivotI]) ll++;
                else swap(arr, ll, rr--);
            }

            pivotI = ll;
            swap(arr, pivotI, r);

            int pivotRank = pivotI - l + 1;
            if (pivotRank == k) return arr[pivotI];
            else if (pivotRank > k) r = pivotI - 1;
            else { l = pivotI + 1; k -= pivotRank; }
        }

        // should not reach here
        return Integer.MIN_VALUE;
    }

    private static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).parallel().distinct().toArray();
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}