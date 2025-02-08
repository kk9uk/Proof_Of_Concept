public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int[] res = { Integer.MIN_VALUE };
        maxPathSumHelper(root, res);
        return res[0];
    }

    private static int maxPathSumHelper(TreeNode curr, int[] res) {
        if (curr == null) return 0;
        int leftSum = maxPathSumHelper(curr.left, res), rightSum = maxPathSumHelper(curr.right, res);
        int fullSum = leftSum + curr.val + rightSum;
        int partialSum =  Math.max(curr.val, curr.val + Math.max(leftSum, rightSum));
        res[0] = Math.max(res[0], Math.max(fullSum, partialSum));
        return partialSum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
