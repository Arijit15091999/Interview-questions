import java.util.*;

public class BellmanFord {
    // applicable only on DG and can handle negative weights and detect negative cycles
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        int[] parent = new int[V];
        parent[src] = src;
        int x = -1;
        for(int i = 0; i < V; i++) {
            for(int[] edge : edges) {
                x = -1;
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dis[v] > dis[u] + wt) {
                    parent[v] = u;
                    x = u;
                    dis[v] = dis[u] + wt;
                }
            }
        }
        if(x != -1) {
            return new int[]{-1};
        }
        return dis;
    }
}
