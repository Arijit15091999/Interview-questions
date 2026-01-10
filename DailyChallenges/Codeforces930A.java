import java.util.*;

public class Codeforces930A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        String[] line = sc.nextLine().trim().split(" ");
        for(int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(line[i - 2]);
            tree.get(parent).add(i);
            tree.get(i).add(parent);
        }

        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});

        while(!q.isEmpty()) {
            int size =q.size();
            count += size % 2;

            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                int parent = node[1];
                int child = node[0];

                for(Integer next : tree.get(child)) {
                    if(next == parent) continue;
                    q.offer(new int[]{next, child});
                }
            }
        }

        System.out.println(count);
    }
}
