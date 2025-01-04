import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            int[] curr = new int[26];
            for (int i = 0; i < str.length(); i++)
                curr[str.charAt(i) - 'a']++;
            res.merge(
                    Arrays.toString(curr),
                    new ArrayList<>(List.of(str)),
                    (old, _) -> {
                        old.add(str);
                        return old;
                    }
            );
        }
        return new ArrayList<>(res.values());
    }
}
