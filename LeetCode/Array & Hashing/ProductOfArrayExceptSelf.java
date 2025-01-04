public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // init with prefix product
        for (int i = 0, accum = 1; i < res.length; i++) {
            res[i] = accum;
            accum *= nums[i];
        }

        // times suffix product
        for (int i = res.length - 1, accum = 1; i >= 0; i--) {
            res[i] *= accum;
            accum *= nums[i];
        }

        return res;
    }
}
