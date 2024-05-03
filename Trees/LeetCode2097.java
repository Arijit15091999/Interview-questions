import java.util.*;

public class LeetCode2097 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(validArrangement(
                new int[][]{
                        {1, 2},
                        {1, 3},
                        {2, 1}
                }
        )));
    }
    public static int[][] validArrangement(int[][] pairs) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap();
        Map<Integer, Integer> degree = new HashMap<>();

        for(int[] pair : pairs) {
            graph.putIfAbsent(pair[0], new ArrayList<>());
            graph.putIfAbsent(pair[1], new ArrayList<>());
            degree.putIfAbsent(pair[0], 0);
            degree.putIfAbsent(pair[1], 0);

            graph.get(pair[0]).add(pair[1]);

            degree.put(pair[0], degree.get(pair[0]) + 1);
            degree.put(pair[1], degree.get(pair[1]) - 1);
        }

        int root = pairs[0][0];

        for(Integer key : degree.keySet()) {
//            System.out.println(degree.keySet().toString());
            if(degree.get(key) == 1) {
                root = key;
                break;
            }
        }

        ArrayList<int[]> path = new ArrayList<>();
        dfs(root, path, graph);

        int[][] res = new int[pairs.length][2];
        int index = 0;

        for(int[] p : path) {
            res[index++] = p;
        }

        return res;
    }

    private static void dfs(int root, ArrayList<int[]> path,
                            Map<Integer, ArrayList<Integer>> graph) {

        ArrayList<Integer> edge = graph.get(root);

        while(edge != null && edge.size() > 0) {
            int child = edge.get(0);
            path.add(new int[]{root, child});
            edge.remove(0);
            dfs(child, path, graph);
        }
    }
}
