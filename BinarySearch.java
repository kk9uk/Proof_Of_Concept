import lombok.experimental.UtilityClass;

@UtilityClass
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        if (nums == null) throw new IllegalArgumentException("binarySearch(): nums shouldn't be null");
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}
