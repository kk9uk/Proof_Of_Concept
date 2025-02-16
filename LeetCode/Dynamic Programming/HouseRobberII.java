public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[1], Math.max(nums[0], nums[2]));
        int prevPrev = nums[0], prev = Math.max(nums[0], nums[1]),
                res = Math.max(prev, nums[2] + prevPrev);
        for (int n = 3; n <= nums.length - 1; n++) {
            res = Math.max(prev, nums[n - 1] + prevPrev);
            prevPrev = prev;
            prev = res;
        }

        prevPrev = nums[1]; prev = Math.max(nums[1], nums[2]);
        int _res = Math.max(prev, nums[3] + prevPrev);
        for (int n = 4; n <= nums.length; n++) {
            _res = Math.max(prev, nums[n - 1] + prevPrev);
            prevPrev = prev;
            prev = _res;
        }
        return Math.max(res, _res);
    }
}