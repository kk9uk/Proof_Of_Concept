import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class NSum {
    public static List<List<Integer>> nSum(int[] nums, int n, int target) {
        if (nums == null) throw new IllegalArgumentException("nSum(): nums shouldn't be null");
        if (1 > n || n > nums.length) throw new IllegalArgumentException("nSum(): n=" + n + " should be in [1, nums.length=" + nums.length + "]");

        Arrays.sort(nums);
        return nSumHelper(nums, n, target, 0);
    }

    private static List<List<Integer>> nSumHelper(int[] nums, int n, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 2) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                // prevent overflow
                long sum = (long) nums[l] + nums[r];
                if (sum == target) {
                    res.add(new ArrayList<>(List.of(nums[r], nums[l])));
                    // avoid dup
                    l++; while (l < r && nums[l] == nums[l - 1]) l++;
                } else if (sum > target) r--; else l++;
            }
        } else {
            // fix one, goes into subproblems
            for (int i = start; i < nums.length - n + 1; i++) {
                // avoid dup
                if (i > start && nums[i] == nums[i - 1]) continue;

                // prevent overflow
                long needed = (long) target - nums[i];
                if (Integer.MIN_VALUE > needed || needed > Integer.MAX_VALUE) continue;
                var subRes = nSumHelper(nums, n - 1, (int) needed, i + 1);
                for (List<Integer> list : subRes) {
                    list.add(nums[i]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
