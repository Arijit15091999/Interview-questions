import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codeforces1843D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            List<List<Integer>> tree = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for(int i = 0; i < n - 1; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                tree.get(u).add(v);
                tree.get(v).add(u);
            }
            int[] dp = new int[n + 1];
            dfs(1, 0, tree, dp);

            int q = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < q; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);

                long ans = (long)dp[u] * dp[v];
                System.out.println(ans);
            }
        }
    }
    private static int dfs(int node, int parent, List<List<Integer>> tree, int[] dp) {
        if(isLeaf(node, parent, tree)) return dp[node] = 1;
        int count = 0;
        for(Integer child : tree.get(node)) {
            if(child == parent) continue;
            count += dfs(child, node, tree, dp);
        }
        return dp[node] = count;
    }
    private static boolean isLeaf(int node, int parent, List<List<Integer>> tree) {
        List<Integer> adj = tree.get(node);
        return adj.size() == 1 && adj.get(0) == parent;
    }
}
