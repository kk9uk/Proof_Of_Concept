public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null) return Integer.MIN_VALUE;
        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            // [l, ..., m, ..., r]: either l..=m or m..=r sorted
            // edge case: not rotated, whole thing sorted -> go left all the way
            if (nums[m] < nums[r]) r = m; else l = m + 1;
        }
        return nums[l];
    }
}
