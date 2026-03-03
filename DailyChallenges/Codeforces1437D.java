import java.net.Inet4Address;
import java.util.*;

public class Codeforces1437D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while(t-- > 0) {
            int n = Integer.parseInt(sc.nextLine().trim());
            String[] line = sc.nextLine().trim().split(" ");
            int[] order = new int[n];

            for(int i = 0; i < n; i++) {
                order[i] = Integer.parseInt(line[i]);
            }

            List<List<Integer>> tree = new ArrayList<>();

            for(int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }

            int parent = 1;
            for(int i = 1; i < n; i++) {
                if(order[i - 1] > order[i]) {
                    parent = order[i - 1];
                }
                tree.get(parent).add(order[i]);
            }
            int depth = depth(1, tree);
            System.out.println(depth);
        }
    }
    private static int depth(int node, List<List<Integer>> tree) {
        if(tree.get(node).size() == 0) {
            return 0;
        }
        int ans = 0;
        for(Integer next : tree.get(node)) {
            ans = Math.max(ans, 1 + depth(next, tree));
        }
        return ans;
    }
}
