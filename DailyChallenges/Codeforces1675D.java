import java.util.*;

public class Codeforces1675D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] line = sc.nextLine().trim().split(" ");
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            solve(n, arr);
            System.out.println();
        }
    }
    private static List<List<Integer>> createTree(int n, int[] parents) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i = 1; i <= n; i++) {
            int node = i;
            int parent = parents[i - 1];
            if(node != parent)
                tree.get(parent).add(node);
        }
        return tree;
    }
    private static int getRoot(int n, int[] arr) {
        for(int i = 1; i <= n; i++) {
            if(arr[i - 1] == i) {
                return i;
            }
        }
        return 0;
    }
    private static void solve(int n, int[] parents) {
        List<List<Integer>> tree = createTree(n, parents);
        List<Integer> leafs = new ArrayList<>();
        int root = getRoot(n, parents);
        getAllLeafs(root, tree, leafs);
        System.out.println(leafs.size());
        getAllPaths(leafs, parents);
    }
    private static void getAllPaths(List<Integer>leafs, int[] parents) {
        Set<Integer> visited = new HashSet<>();
        for(Integer leaf : leafs) {
            List<Integer> path = new ArrayList<>();
            int node = leaf;
            while(!visited.contains(node)) {
                path.add(node);
                visited.add(node);
                node = parents[node - 1];
            }
            int n = path.size();
            System.out.println(n);
            for(int i = n - 1; i >= 0; i--) {
                if(i == 0) {
                    System.out.println(path.get(i) + " ");
                }else
                    System.out.print(path.get(i) + " ");
            }
        }
    }
    private static void getAllLeafs(int root, List<List<Integer>> tree, List<Integer> res) {
        List<Integer> children = tree.get(root);
        if(children.size() == 0) {
            res.add(root);
            return;
        }
        for(Integer child : children) {
            getAllLeafs(child, tree, res);
        }
    }
}
