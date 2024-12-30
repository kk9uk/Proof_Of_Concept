import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public class Dijkstra {
    public static HashMap<Integer, Integer> dijkstra(int n, int src, List<int[]> edges) {
        if (n < 1) throw new IllegalArgumentException("dijkstra(): n=" + n + " should be at least one");
        if (0 > src || src >= n) throw new IllegalArgumentException("dijkstra(): Invalid src=" + src);
        if (edges == null) throw new IllegalArgumentException("dijkstra(): edges shouldn't be null");
        for (int[] edge : edges) {
            // int from = edge[0], to = edge[1], cost = edge[2];
            if (
                    (edge.length != 3) ||
                            (0 > edge[0] || edge[0] >= n) ||
                            (0 > edge[1] || edge[1] >= n)
            )
                throw new IllegalArgumentException("dijkstra(): Invalid edge=" + Arrays.toString(edge));
        }

        HashMap<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++)
            adjList.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], cost = edge[2];
            adjList.get(from).add(new int[] { to, cost });
        }

        HashMap<Integer, Integer> res = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));
        minHeap.add(new int[] { src, 0 });
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            int vertex = curr[0], cost = curr[1];

            if (res.containsKey(vertex)) continue;
            res.put(vertex, cost);

            for (int[] edge : adjList.get(vertex)) {
                // int to = edge[0], cost = edge[1];
                if (res.containsKey(edge[0])) continue;
                minHeap.add(new int[] { edge[0], cost + edge[1] });
            }
        }

        // -1 for unreachable
        for (int i = 0; i < n; i++)
            res.putIfAbsent(i, -1);
        return res;
    }
}