import java.util.*;

public class LeetCode721 {
    private class DisjointSet {
        List<Integer> size;
        List<Integer> parents;
        DisjointSet(int n) {
            this.size = new ArrayList<>();
            this.parents = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                this.size.add(1);
                this.parents.add(i);
            }
        }
        int findUltimateParent(int node) {
            if(node == parents.get(node)) {
                return node;
            }
            parents.set(node, findUltimateParent(parents.get(node)));
            return parents.get(node);
        }
        boolean union(int u, int v) {
            int parentU = findUltimateParent(u);
            int parentV = findUltimateParent(v);
            if(parentU == parentV) return false;

            int sizeU = size.get(parentU);
            int sizeV = size.get(parentV);

            if(sizeU < sizeV) {
                parents.set(parentU, parentV);
                size.set(parentV, sizeU + sizeV);
            }else {
                parents.set(parentV, parentU);
                size.set(parentU, sizeU + sizeV);
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> emailToOwnerMap = new HashMap<>();
        Map<String, PriorityQueue<String>> nameAndEmailMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            List<String> emails = accounts.get(i);
            String name = emails.get(0);
            nameAndEmailMap.put(name + " " + i, new PriorityQueue<>());
            for(int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                if(emailToOwnerMap.containsKey(email)) {
                    int prevOwner = emailToOwnerMap.get(email);
                    ds.union(prevOwner, i);
                }
                emailToOwnerMap.put(email, i);
            }
        }

        for(Map.Entry<String, Integer> entry : emailToOwnerMap.entrySet()) {
            String email = entry.getKey();
            Integer owner = entry.getValue();

            int realOwner = ds.findUltimateParent(owner);
            String key = accounts.get(realOwner).get(0) + " " + realOwner;

            nameAndEmailMap.get(key).offer(email);
        }

        for(Map.Entry<String, PriorityQueue<String>> entry : nameAndEmailMap.entrySet()) {
            String name = entry.getKey().split(" ")[0];
            PriorityQueue<String> emailForTheName = entry.getValue();
            List<String> set = new ArrayList<>();
            if(emailForTheName.size() > 0) {
                set.add(name);
                while(emailForTheName.size() > 0) {
                    set.add(emailForTheName.poll());
                }
                res.add(set);
            }
        }

        return res;
    }
}
