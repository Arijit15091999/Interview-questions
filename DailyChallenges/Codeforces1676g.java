import java.util.*;

public final class Codeforces1676g {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] line = sc.nextLine().trim().split(" ");
            int[] parents = new int[n - 1];
            for(int i = 0; i < n - 1; i++) {
                parents[i] = Integer.parseInt(line[i]);
            }
            String colors = sc.nextLine();
            Map<Integer, List<Integer>> tree = createTree(n, colors, parents);
            int ans = dfs(tree,colors);
            System.out.println(ans);
        }
    }
    private static Map<Integer, List<Integer>> createTree(int n, String colors, int[] parents) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        tree.put(1, new ArrayList<>());
        for(int i = 0; i < n - 1; i++) {
            int node = i + 2;
            int parent = parents[i];
            char color = colors.charAt(i);
            List<Integer> adj = tree.getOrDefault(parent, new ArrayList<>());
            adj.add(node);
            tree.put(parent, adj);
            if(!tree.containsKey(node)) {
                tree.put(node, new ArrayList<>());
            }
        }
        return tree;
    }
    private static int dfs(Map<Integer, List<Integer>>tree, String colors) {
        int[] ans = new int[]{0};
        dfsHelper(1, tree, colors, ans);
        return ans[0];
    }
    private static int dfsHelper(int node, Map<Integer, List<Integer>> tree, String colors, int[] ans) {
        int score = node >= 1 && colors.charAt(node - 1) == 'B' ? -1 : 1;
        int res = 0;

        for(Integer child : tree.get(node)) {
            res += dfsHelper(child, tree, colors, ans);
        }
        if(score + res == 0) {
            ans[0]++;
        }
        return score + res;
    }
}
