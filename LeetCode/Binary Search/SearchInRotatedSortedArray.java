public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null) return -1;

        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] < nums[r]) r = m; else l = m + 1;
        }

        if (target > nums[nums.length - 1]) return binarySearch(nums, 0, l - 1, target);
        else return binarySearch(nums, l, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int l, int r, int target) {
        int m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }
}