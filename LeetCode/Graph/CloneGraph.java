import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    private static Node dfs(Node node, HashMap<Node, Node> oldToNew) {
        if (oldToNew.containsKey(node)) return oldToNew.get(node);
        Node clone = new Node(node.val);
        oldToNew.put(node, clone);
        for (Node neighbor : node.neighbors)
            clone.neighbors.add(dfs(neighbor, oldToNew));
        return clone;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }
}
