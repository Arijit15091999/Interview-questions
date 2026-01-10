import java.util.*;
public class Leetcode1334 {
    // floyed warshall algo
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        for(int[] d : dis) {
            Arrays.fill(d, (int)1e8);
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dis[u][v] = wt;
        }
        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) {
                        dis[i][i] = 0;
                        continue;
                    }
                    dis[i][j] = Math.min(
                            dis[i][j],
                            dis[i][via] + dis[via][j]
                    );
                }
            }
        }
        int ans = 0;
        int min = n + 1;

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(dis[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(count <= min) {
                min = count;
                ans = Math.max(i, ans);
            }
        }
        return ans;
    }
}
