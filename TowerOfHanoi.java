import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TowerOfHanoi {
    public static List<List<Character>> towerOfHanoi(int n) {
        if (n < 1) throw new IllegalArgumentException("towerOfHanoi(): n=" + n + " should be at least 1");

        List<List<Character>> res = new ArrayList<>();
        towerOfHanoiHelper(n, res, 'A', 'C', 'B');
        return res;
    }

    private static void towerOfHanoiHelper(int n, List<List<Character>> res, char from, char to, char tmp) {
        if (n == 1) { res.add(List.of(from, to)); return; }
        towerOfHanoiHelper(n - 1, res, from, tmp, to);
        res.add(List.of(from, to));
        towerOfHanoiHelper(n - 1, res, tmp, to, from);
    }
}
