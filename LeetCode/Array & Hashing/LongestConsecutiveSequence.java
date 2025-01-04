import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);

        int res = 0;
        for (var num : seen)
            // start of seq: no num - 1
            if (!seen.contains(num - 1)) {
                int curr = 1;
                while (seen.contains(num + curr)) curr++;
                if (curr > res) res = curr;
            }
        return res;
    }

    /* counting (sort): O(n + range of values)
     *
     * public int longestConsecutive(int[] nums) {
     *     if (nums == null || nums.length == 0) return 0;

     *     int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
     *     for (int num : nums) {
     *         if (num < min) min = num;
     *         if (num > max) max = num;
     *     }

     *     int[] arr = new int[max - min + 1];
     *     for (int num : nums)
     *         arr[num - min] = 1;

     *     int res = 0, i = 0, l, r;
     *     while (i < arr.length) {
     *         l = i;
     *         while (arr[l] != 1) l++;

     *         r = l;
     *         while (r < arr.length && arr[r] == 1) r++;

     *         if (r - l > res) res = r - l;
     *         i = r;
     *     }
     *     return res;
     * } */
}
