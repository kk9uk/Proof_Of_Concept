import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Random;

@UtilityClass
public class QuickSelect {

    /* This is an in-place, randomized, and iterative implementation of Quick Select, by kk9uk. */

    /* Credit to Prof. Yufei Tao, who gave lectures so well, such that I got this at first try in one go, two years later.
     * Here's his take on recursion, which instilled in me a profound intuition:
     *
     * When dealing with a subproblem, consider it solved, as if by magic, and use the subproblem's output to continue the algorithm design. */

    public static int quickSelect(int[] arr, int k) {
        if (arr == null) throw new IllegalArgumentException("quickSelect(): arr shouldn't be null");
        if (1 > k || k > arr.length) throw new IllegalArgumentException("quickSelect(): k=" + k + " should be in [1, arr.length=" + arr.length + "]");

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
