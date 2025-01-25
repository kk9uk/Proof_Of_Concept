import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        HashSet<Character> seen = new HashSet<>();
        int res = 0, l = 0, r = 0;
        while (r < s.length()) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    /* [OPT]: Bookkeep seen char index
     * public int lengthOfLongestSubstring(String s) {
     *     if (s == null || s.isEmpty()) return 0;
     *     HashMap<Character, Integer> seen = new HashMap<>();
     *     int res = 0, l = 0, r = 0;
     *     while (r < s.length()) {
     *         if (seen.containsKey(s.charAt(r)))
     *             // last seen index could be out of curr window already
     *             l = Math.max(l, seen.get(s.charAt(r)) + 1);
     *         seen.put(s.charAt(r), r);
     *         res = Math.max(res, r - l + 1);
     *         r++;
     *     }
     *     return res;
     * } */
}