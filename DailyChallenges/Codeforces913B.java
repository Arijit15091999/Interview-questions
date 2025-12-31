import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codeforces913B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            sc.nextLine();
            tree.get(parent).add(i + 2);
            tree.get(i + 2).add(parent);
        }
        String ans = dfs(tree) ? "Yes" : "No";
        System.out.println(ans);
    }
    private static boolean dfs(List<List<Integer>> tree) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        helper(1, 0, tree, ans);
        return ans[0];
    }
    private static void helper(int node, int parent, List<List<Integer>> tree, boolean[] ans) {
        if(node == parent) return;
        if(isLeaf(node, parent, tree)) return;
        int count = 0;
        if(!ans[0]) {
            return;
        }
        for(Integer child : tree.get(node)) {
            if(child == parent) continue;
            if(isLeaf(child, node, tree)) {
                count += 1;
            }else
                helper(child, node, tree, ans);
        }
        if(count < 3) {
            ans[0] = false;
        }
    }
    private static boolean isLeaf(int node, int parent, List<List<Integer>> tree) {
        List<Integer> adj = tree.get(node);
        return adj.size() == 1 && adj.get(0) == parent;
    }
}
