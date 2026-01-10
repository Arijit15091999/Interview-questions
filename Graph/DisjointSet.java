import java.util.*;
public class DisjointSet {
    List<Integer> size;
    List<Integer> parents;
    public DisjointSet(int n) {
        this.size = new ArrayList<>();
        this.parents = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            size.add(1);
            parents.add(i);
        }
    }
    public int findUltimateParent(int node) {
        if(node == parents.get(node)) {
            return node;
        }
        int parent = findUltimateParent(parents.get(node));
        parents.set(node, parent);
        return parent;
    }
    public void union(int u, int v) {
        int parentU = findUltimateParent(u);
        int parentV = findUltimateParent(v);

        if(parentU == parentV) return;

        int sizeU = size.get(parentU);
        int sizeV = size.get(parentV);

        if(sizeU < sizeV) {
            parents.set(parentU, parentV);
            size.set(parentV, sizeU + sizeV);
        }else {
            parents.set(parentV, parentU);
            size.set(parentU, sizeU + sizeV);
        }
    }
}
