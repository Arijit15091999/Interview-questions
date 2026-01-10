import java.util.*;

public class PrimsAlgorithm {
    public int spanningTree(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        List<int[]> mst = new ArrayList<>();
        int[] vis = new int[V];
        pq.offer(new int[]{0, -1, 0});
        int sum = 0;
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            mst.add(node);
            int curr = node[0];
            if(vis[curr] == 1)continue;
            vis[curr] = 1;
            int parent = node[1];
            int wt = node[2];
            sum += wt;
            for(int[] adjNode : adj.get(node[0])) {
                int nextNode = adjNode[0];
                int weight = adjNode[1];
                if(nextNode == parent || vis[nextNode] == 1) continue;
                pq.offer(new int[]{nextNode, curr, weight});
            }
        }
        return sum;
    }
}
