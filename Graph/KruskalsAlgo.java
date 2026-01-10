import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgo {
    public int mst(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt((a) -> a[2]));
        DisjointSet ds = new DisjointSet(V);
        int edgeSum = 0;
        int edgesUsed = 0;
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            int parentU = ds.findUltimateParent(u);
            int parentV = ds.findUltimateParent(v);

            if(parentU != parentV) {
                edgeSum += wt;
                ds.union(u, v);
                edgesUsed++;
            }
            if(edgesUsed == V - 1) break;
        }
        return edgeSum;
    }
}
