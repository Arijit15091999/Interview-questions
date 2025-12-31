import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codeforces755C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] line = sc.nextLine().trim().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        List<List<Integer>> graph = createGraph(arr, n);
        int ans = connectedComponents(graph, n);
        System.out.println(ans);
    }
    private static List<List<Integer>> createGraph(int[] arr, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 1; i <= n; i++) {
            int relative = arr[i - 1];
            graph.get(i).add(relative);
            graph.get(relative).add(i);
        }
        return graph;
    }
    private static int connectedComponents(List<List<Integer>> graph, int n) {
        boolean[] vis = new boolean[n + 1];
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!vis[i]){
                count++;
                helper(i, graph, vis);
            }
        }
        return count;
    }
    private static void helper(int node, List<List<Integer>> graph, boolean[] vis) {
        if(vis[node]) {
            return;
        }
        vis[node] = true;
        for(Integer child : graph.get(node)) {
            if(!vis[child]) {
                helper(child, graph, vis);
            }
        }
    }
}
