import java.util.ArrayList;
import java.util.List;

public class LeetCode1319 {
    private class DisjointSet {
        List<Integer> size;
        List<Integer> parents;
        DisjointSet(int n) {
            this.size = new ArrayList<>();
            this.parents = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                size.add(1);
                parents.add(i);
            }
        }
        int findUltimateParent(int node) {
            if(node == parents.get(node)) {
                return node;
            }
            parents.set(node, findUltimateParent(parents.get(node)));
            return parents.get(node);
        }
        void union(int u, int v) {
            int parentU = findUltimateParent(u);
            int parentV = findUltimateParent(v);
            if(parentU == parentV) {
                return;
            }
            int sizeU = size.get(parentU);
            int sizeV = size.get(parentV);

            if(sizeV < sizeU) {
                parents.set(parentV, parentU);
                size.set(parentU, sizeU + sizeV);
            }else {
                parents.set(parentU, parentV);
                size.set(parentV, sizeU + sizeV);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int count = 0;
        for(int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            int parentU = ds.findUltimateParent(u);
            int parentV = ds.findUltimateParent(v);
            if(parentU == parentV) {
                count++;
            }
            ds.union(u, v);
        }
        int numberOfConnectedComponents = 0;
        for(int i = 0; i < n; i++) {
            if(i == ds.findUltimateParent(i)) numberOfConnectedComponents++;
        }
        if(numberOfConnectedComponents - 1 <= count) {
            return numberOfConnectedComponents - 1;
        }
        return -1;
    }
}
