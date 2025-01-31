import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@UtilityClass
public class nPk {
    public static <T> List<List<T>> nPk(List<T> list, int k) {
        if (list == null) throw new IllegalArgumentException("nPk(): list shouldn't be null");
        if (k < 0) throw new IllegalArgumentException("nPk(): k shouldn't be negative, now k=" + k);
        if (list.size() < k) throw new IllegalArgumentException("nPk(): k=" + k + " shouldn't be larger than list.size()=" + list.size());

        List<List<T>> res = new ArrayList<>();
        nPkHelper(list, k, res, new ArrayList<>(), new HashSet<>());
        return res;
    }

    private static <T> void nPkHelper(List<T> list, int k, List<List<T>> res, List<T> curr, HashSet<T> picked) {
        if (curr.size() == k) { res.add(new ArrayList<>(curr)); return; }
        for (T val : list) {
            if (picked.contains(val)) continue;
            curr.add(val); picked.add(val);
            nPkHelper(list, k, res, curr, picked);
            curr.remove(curr.size() - 1); picked.remove(val);
        }
    }
}
