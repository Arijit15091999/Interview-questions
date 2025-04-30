import java.util.*;

public class ThreeTraversals {
    private static class Pair {
        public TreeNode node;
        public int level;
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> traversals(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(root, 1));

        while(!st.isEmpty()) {
            Pair pair = st.pop();
            TreeNode node = pair.node;
            int level = pair.level;

            if(level == 1) {
                preorder.add(node.val);
            }else if(level == 2) {
                inorder.add(node.val);
            }else{
                postorder.add(node.val);
            }

            if(level < 3) {
                st.push(new Pair(node, level + 1));

                if(level == 1) {
                    if(node.left != null) {
                        st.push(new Pair(node.left, 1));
                    }
                }
                if(level == 2) {
                    if(node.right != null) {
                        st.push(new Pair(node.right, 1));
                    }
                }
            }

        }

        list.add(preorder);
        list.add(inorder);
        list.add(postorder);


        return list;
    }
}
