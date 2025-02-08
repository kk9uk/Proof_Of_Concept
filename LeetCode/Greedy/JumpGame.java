public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int maxReach = nums[0];
        for (int i = 0; i <= maxReach && maxReach < nums.length - 1; i++)
            maxReach = Math.max(maxReach, i + nums[i]);
        return maxReach >= nums.length - 1;
    }

    /* backward
     * public boolean canJump(int[] nums) {
     *     if (nums == null || nums.length == 0) return false;
     *     int target = nums.length - 1;
     *     for (int i = target - 1; i >= 0; i--)
     *         if (i + nums[i] >= target) target = i;
     *     return target == 0;
     * } */
}
