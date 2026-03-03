import java.util.*;
public class Leetcode1791 {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n + 1];

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;
        }

        for(int i = 1; i <= n; i++) {
            if(degree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
