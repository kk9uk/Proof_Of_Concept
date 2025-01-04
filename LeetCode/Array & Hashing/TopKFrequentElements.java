import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums)
            count.merge(num, 1, (old, val) -> old + val);

        // counting sort by freq
        List<Integer>[] tnuoc = new List[nums.length + 1];
        for (var entry : count.entrySet()) {
            if (tnuoc[entry.getValue()] == null)
                tnuoc[entry.getValue()] = new ArrayList<>();
            tnuoc[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        for (int i = tnuoc.length - 1, resI = 0; i >= 0 && resI < k; i--)
            if (tnuoc[i] != null)
                for (int j = 0; j < tnuoc[i].size(); j++)
                    res[resI++] = tnuoc[i].get(j);
        return res;
    }
}
