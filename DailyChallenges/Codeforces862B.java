import java.util.*;

public final class Codeforces862B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            List<Integer> list = graph.getOrDefault(u, new ArrayList<>());
            list.add(v);
            graph.put(u, list);
            list = graph.getOrDefault(v, new ArrayList<>());
            list.add(u);
            graph.put(v, list);
        }
//        int root = findRoot(graph);
        long total = bfs(n, graph);
        System.out.println(total - n + 1);
    }
    private static int findRoot(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();
        for(Integer key : graph.keySet()) {
            if(!indegree.containsKey(key)) {
                indegree.put(key, 0);
            }
            for(Integer node : graph.get(key)) {
                int degree = indegree.getOrDefault(node, 0);
                indegree.put(node, degree + 1);
            }
        }
        for(Integer key : graph.keySet()) {
            if(indegree.get(key) == 0) {
                return key;
            }
        }
        return -1;
    }
    private static long bfs(int n, Map<Integer, List<Integer>> graph) {
        int set1 = 0, set2 = 0;
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        colors[1] = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int node = q.poll();
                if(colors[node] == 0) {
                    set1++;
                }else {
                    set2++;
                }
                for(Integer child : graph.get(node)) {
                    if(colors[child] != -1) continue;
                    int color = 1 - colors[node];
                    colors[child] = color;
                    q.offer(child);
                }
            }
        }
        return (long)set1 * set2;
    }
}
