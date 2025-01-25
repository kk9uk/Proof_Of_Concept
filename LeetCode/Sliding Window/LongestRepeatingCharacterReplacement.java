import java.util.HashSet;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;

        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            seen.add(s.charAt(i));

        int res = 0;
        // O(26n) is still O(n).
        for (char c : seen) {
            int count = 0, l = 0, r = 0;
            while (r < s.length()) {
                if (s.charAt(r) == c) count++;

                while (r - l + 1 - count > k) {
                    if (s.charAt(l) == c) count--;
                    l++;
                }

                res = Math.max(res, r - l + 1);
                r++;
            }
        }
        return res;
    }

    /* O(n), but one has to be very smart to realize that "no need fix/decrement maxCount"
     * public int characterReplacement(String s, int k) {
     *     if (s == null || s.isEmpty()) return 0;
     *     HashMap<Character, Integer> count = new HashMap<>();
     *     int res = 0, maxCount = 0, l = 0, r = 0;
     *     while (r < s.length()) {
     *         count.merge(s.charAt(r), 1, (a, b) -> a + b);
     *         maxCount = Math.max(maxCount, count.get(s.charAt(r)));

     *         if (r - l + 1 - maxCount > k) {
     *             count.merge(s.charAt(l), -1, (a, b) -> a + b);
     *             l++;
     *             // no need decrement maxCount, as res only changes if later a larger maxCount appears
     *         }

     *         res = Math.max(res, r - l + 1);
     *         r++;
     *     }
     *     return res;
     * } */
}