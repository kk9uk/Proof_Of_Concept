import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";

        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            countT.merge(t.charAt(i), 1, (a, b) -> a + b);

        HashMap<Character, Integer> countS = new HashMap<>();
        int resL = 0, resR = s.length(), l = 0, r = 0, missing = countT.size();
        while (r < s.length()) {
            if (countT.containsKey(s.charAt(r))) {
                countS.merge(s.charAt(r), 1, (a, b) -> a + b);
                if (countS.get(s.charAt(r)).equals(countT.get(s.charAt(r)))) missing--;
            }

            while (missing == 0) {
                if (r - l + 1 < resR - resL + 1) {
                    resL = l;
                    resR = r;
                }

                if (countT.containsKey(s.charAt(l))) {
                    countS.merge(s.charAt(l), -1, (a, b) -> a + b);
                    if (countS.get(s.charAt(l)) < countT.get(s.charAt(l))) missing++;
                }

                l++;
            }

            r++;
        }
        return resR == s.length() ? "" : s.substring(resL, resR + 1);
    }
}