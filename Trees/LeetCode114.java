import java.util.*;

public class LeetCode114 {
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
        return preorderStack(root);
    }
    private void helper(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        list.add(root.val);

        helper(root.left, list);
        helper(root.right, list);
    }

    private List<Integer> preorderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root != null){
            stack.push(root);
        }

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }

        return res;
    }
}
