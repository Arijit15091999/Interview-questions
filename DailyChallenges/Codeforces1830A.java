import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Codeforces1830A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] id = new int[n + 1];
            Arrays.fill(id, Integer.MAX_VALUE);
            List<List<int[]>> tree = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            for(int i = 0; i < n - 1; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                tree.get(u).add(new int[]{v, i});
                tree.get(v).add(new int[]{u, i});
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            id[1] = 0;
            dfs(1, 0, tree, dp, id);
            int max = 0;

            for(int i = 1; i <= n; i++) {
                int d = dp[i];
                max = Math.max(d, max);
            }
            System.out.println(max);
        }
    }
    private static void dfs(int node, int parent, List<List<int[]>> tree, int[] dp, int[] id) {
        for (int[] edge : tree.get(node)) {
            int v = edge[0];
            int index = edge[1];

            if (v == parent) continue;

            if (id[node] <= index) {
                dp[v] = dp[node];
            } else {
                dp[v] = dp[node] + 1;
            }

            id[v] = index;
            dfs(v, node, tree, dp, id);
        }
    }


}
