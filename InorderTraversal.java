import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class InorderTraversal {
    public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null) throw new IllegalArgumentException("inorderTraversal(): root shouldn't be null");
        List<Integer> res = new ArrayList<>();
        inorderTraversalHelper(root, res);
        return res;
    }

    private static void inorderTraversalHelper(BinaryTreeNode<Integer> curr, List<Integer> res) {
        if (curr.left != null) inorderTraversalHelper(curr.left, res);
        res.add(curr.val);
        if (curr.right != null) inorderTraversalHelper(curr.right, res);
    }

    public static class BinaryTreeNode<T> {
        private BinaryTreeNode<T> left;
        private T val;
        private BinaryTreeNode<T> right;
    }
}