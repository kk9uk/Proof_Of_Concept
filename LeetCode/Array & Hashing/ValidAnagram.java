import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> countS = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            countS.merge(s.charAt(i), 1, (a, b) -> a + b);

        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            countT.merge(t.charAt(i), 1, (a, b) -> a + b);

        return countS.equals(countT);
    }
}
