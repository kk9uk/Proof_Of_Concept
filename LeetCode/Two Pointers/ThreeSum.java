import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // avoid dup
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                // prevent overflow
                long sum = (long) nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    // avoid dup
                    l++; while (l < r && nums[l] == nums[l - 1]) l++;
                } else if (sum > 0) r--; else l++;
            }
        }
        return res;
    }

    /* HashMap: still O(n^2), but hashing is slow
     * public List<List<Integer>> threeSum(int[] nums) {
     *     HashMap<Integer, Integer> count = new HashMap<>();
     *     for (var num : nums)
     *         count.merge(num, 1, (a, b) -> a + b);

     *     nums = Arrays.stream(nums).parallel().sorted().toArray();
     *     List<List<Integer>> res = new ArrayList<>();
     *     for (int i = 0; i < nums.length; i++) {
     *         count.merge(nums[i], -1, (a, _) -> a - 1);
     *         if (i > 0 && nums[i] == nums[i - 1]) continue;

     *         for (int j = i + 1; j < nums.length; j++) {
     *             count.merge(nums[j], -1, (a, _) -> a - 1);
     *             if (j > i + 1 && nums[j] == nums[j - 1]) continue;

     *             // prevent overflow
     *             long target = 0L - nums[i] - nums[j];
     *             if (Integer.MIN_VALUE > target || target > Integer.MAX_VALUE) continue;
     *             if (count.getOrDefault((int) target, 0) > 0)
     *                 res.add(List.of(nums[i], nums[j], (int) target));
     *         }

     *         for (int j = i + 1; j < nums.length; j++)
     *             count.merge(nums[j], 1, (a, b) -> a + b);
     *     }
     *     return res;
     * } */
}
