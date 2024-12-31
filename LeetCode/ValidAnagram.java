package LeetCode;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> countS = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);

        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);

        return countS.equals(countT);
    }
}
