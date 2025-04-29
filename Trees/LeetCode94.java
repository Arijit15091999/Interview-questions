import java.util.*;

public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> list) {
        Stack<TreeNode> st = new Stack<>();

        while(root != null) {
            st.push(root);
            root = root.left;
        }

        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);

            if(node.right != null) {
                node = node.right;
                while(node != null) {
                    st.push(node);
                    node = node.left;
                }
            }
        }
    }
}
