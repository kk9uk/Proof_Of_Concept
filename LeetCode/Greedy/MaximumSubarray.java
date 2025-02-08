public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int prev = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev >= 0) prev += nums[i]; else prev = nums[i];
            res = Math.max(res, prev);
        }
        return res;
    }
}
