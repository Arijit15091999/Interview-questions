import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codeforces690C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> tree = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        int[] ans = new int[1];

        diameter(1, 0, tree, ans);

        System.out.println(ans[0]);
    }
    private static int diameter(int node, int parent, List<List<Integer>> tree, int[] ans) {
        int first = 0;
        int second = 0;

        for(Integer next : tree.get(node)) {
            if(next == parent) continue;
            int res = 1 + diameter(next, node, tree, ans);
            if(res > first) {
                second = first;
                first = res;
            }else if(res > second) {
                second = res;
            }
        }

        ans[0] = Math.max(ans[0], first + second);

        return Math.max(first, second);
    }
}
