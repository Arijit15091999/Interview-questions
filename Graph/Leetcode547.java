import java.net.Inet4Address;
import java.util.*;

public class Leetcode547 {
    public int findCircleNumUsingDfs(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                count++;
                dfs(i, vis, graph);
            }
        }
        return count;
    }
    private void dfs(int node, boolean[] vis, List<List<Integer>> graph) {
        vis[node] = true;
        for(Integer adjNode : graph.get(node)) {
            if(!vis[adjNode]) {
                dfs(adjNode, vis, graph);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        return solve(n, graph);
    }
    private int solve(int n, List<List<Integer>> graph) {
        DisjointSet ds = new DisjointSet(n);
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(Integer adjNode : graph.get(i)) {
                ds.union(i, adjNode);
            }
        }
        for(int i = 0; i < n; i++) {
            if(ds.findUltimateParent(i) == i) count++;
        }
        return count;
    }
}
