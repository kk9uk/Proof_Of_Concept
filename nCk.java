import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class nCk {
    public static <T> List<List<T>> nCk(List<T> list, int k) {
        if (list == null) throw new IllegalArgumentException("nCk(): list shouldn't be null");
        if (k < 0) throw new IllegalArgumentException("nCk(): k shouldn't be negative, now k=" + k);
        if (list.size() < k) throw new IllegalArgumentException("nCk(): k=" + k + " shouldn't be larger than list.size()=" + list.size());

        List<List<T>> res = new ArrayList<>();
        nCkHelper(list, k, res, new ArrayList<>(), 0);
        return res;
    }

    private static <T> void nCkHelper(List<T> list, int k, List<List<T>> res, List<T> curr, int currI) {
        if (curr.size() == k) { res.add(new ArrayList<>(curr)); return; }
        // [OPT]: i + (k - curr.size() - 1) < list.size()
        for (int i = currI; i < list.size(); i++) {
            curr.add(list.get(i));
            nCkHelper(list, k, res, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
