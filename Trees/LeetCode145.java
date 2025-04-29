import java.util.*;

public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        Collections.reverse(list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);

            if(node.left != null) {
                st.push(node.left);
            }

            if(node.right != null) {
                st.push(node.right);
            }
        }
    }
}
