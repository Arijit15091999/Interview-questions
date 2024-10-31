import java.util.*;

public class ShortestPath {
    private class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        int[] dis = new int[V];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adj.get(u).add(new Pair(v, weight));
        }

        Arrays.fill(dis, (int)1e9);

        dis[0] = 0;
        List<Integer> topoSort = topoSort(adj);

        for(Integer node : topoSort) {
            for(Pair pair : adj.get(node)) {
                int v = pair.node;
                int weight = pair.weight;

                if(dis[node] + weight < dis[v]) {
                    dis[v] = dis[node] + weight;
                }
            }
        }

        for(int i = 0; i < V; i++) {
            if(dis[i] >= (int)1e9) {
                dis[i] = -1;
            }
        }

        return dis;
    }

    private List<Integer> topoSort(ArrayList<ArrayList<Pair>> adj) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int n = adj.size();
        int[] inDegree = new int[n];

        for(int i = 0; i < n; i++) {
            for(Pair pair : adj.get(i)) {
                int node = pair.node;
                inDegree[node]++;
            }
        }

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int root = q.remove();
                res.add(root);

                for(Pair pair : adj.get(root)) {
                    int node = pair.node;
                    inDegree[node]--;
                    if(inDegree[node] == 0) {
                        q.offer(node);
                    }
                }
            }
        }
        return res;
    }
}
