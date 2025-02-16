public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // f(1) = nums[0], f(2) = Math.max(nums[0], nums[1]),
        // f(n) = Math.max(f(n - 1), nums[n - 1] + f(n - 2)) (for n >= 3)
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int prevPrev = nums[0], prev = Math.max(nums[0], nums[1]),
                res = Math.max(prev, nums[2] + prevPrev);
        for (int n = 3; n <= nums.length; n++) {
            res = Math.max(prev, nums[n - 1] + prevPrev);
            prevPrev = prev;
            prev = res;
        }
        return res;
    }
}