public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        return 1 + Math.max(left, right);
    }
}

