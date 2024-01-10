import java.util.*;

// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/submissions/

class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>();

        TreeNode startNode = populateParentAndFindStartNode(root, map, start);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<>();
        int time = 0;


        q.offer(startNode);
        visited.add(startNode);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean isInfected = false;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                TreeNode left = node.left, right = node.right, parent = map.get(node);

                if (!visited.contains(left) && left != null) {
                    visited.add(left);
                    isInfected = true;
                    q.offer(left);
                }
                if (!visited.contains(right) && right != null) {
                    visited.add(right);
                    isInfected = true;
                    q.offer(right);
                }
                if (!visited.contains(parent) && parent != null) {
                    visited.add(parent);
                    isInfected = true;
                    q.offer(parent);
                }
            }
            
            if (isInfected)
                time++;
        }
        return time;
    }

    private TreeNode populateParentAndFindStartNode(TreeNode root, Map<TreeNode, TreeNode> map, int start) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode startNode = null;

        map.put(root, null);
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();

            if (parent.val == start) {
                startNode = parent;            }

            if (parent.left != null) {
                q.offer(parent.left);
                map.put(parent.left, parent);
            }
            if (parent.right != null) {
                q.offer(parent.right);
                map.put(parent.right, parent);
            }
        }

        return startNode;
    }
}