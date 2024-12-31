import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public class Dijkstra {
    public Map<Integer, Integer> dijkstra(int n, List<List<Integer>> edges, int src) {
        // TODO: checks

        // adj list
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());
        for (List<Integer> edge : edges) {
            int from = edge.get(0), to = edge.get(1), val = edge.get(2);
            adj.get(from).add(new int[] { to, val });
        }

        Map<Integer, Integer> res = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[] { src, 0 });
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            // greedy
            if (res.containsKey(curr[0])) continue;
            res.put(curr[0], curr[1]);

            // variant of relax
            for (int[] edge : adj.get(curr[0]))
                if (!res.containsKey(edge[0]))
                    minHeap.add(new int[] { edge[0], curr[1] + edge[1] });
        }
        for (int i = 0; i < n; i++)
            // unreachable
            res.putIfAbsent(i, -1);
        return res;
    }
}
