import java.util.*;

public final class Codeforces522A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, List<String>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] edge = sc.nextLine().trim().split(" ");
            String owner = edge[2].toLowerCase();
            String consumer = edge[0].toLowerCase();
            List<String> adjacency = graph.getOrDefault(owner, new ArrayList<>());
            adjacency.add(consumer);
            graph.put(owner, adjacency);
            graph.put(consumer, new ArrayList<>());
        }
        int ans = solve(n + 1, graph);
        System.out.println(ans);
    }
    private static int solve(int n, Map<String, List<String>> graph) {
        return dfs("Polycarp", graph);
    }
    private static int dfs(String root, Map<String, List<String>> graph) {
        root = root.toLowerCase();
        List<String> adjacency = graph.get(root);
        int ans = 1;
        for(String child : adjacency) {
            ans = Math.max(
                    ans,
                    1 + dfs(child, graph)
            );
        }
        return ans;
    }
}
