import java.util.*;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> subset = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                subset.add(node.val);

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            list.add(subset);
        }
        return list;
    }
}
