import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codeforces982C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        if((n & 1) == 1) {
            System.out.println(-1);
        }else {
            int[] ans = new int[1];
            dfs(1, 0, tree, ans);
            System.out.println(ans[0]);
        }

    }
    private static int dfs(int node, int parent, List<List<Integer>> tree, int[] ans) {
        if(isLeaf(node, parent, tree)) {
            return 1;
        }
        int size = 1;
        for(Integer next : tree.get(node)) {
            if(next == parent) continue;
            int subTreeSize = dfs(next, node, tree, ans);
            if((subTreeSize & 1) == 0) ans[0]++;
            size += subTreeSize;
        }
        return size;
    }
    private static boolean isLeaf(int node, int parent, List<List<Integer>> tree) {
        boolean ans = true;
        for(Integer next : tree.get(node)) {
            if(next == parent) continue;
            ans = false;
        }
        return ans;
    }
}
