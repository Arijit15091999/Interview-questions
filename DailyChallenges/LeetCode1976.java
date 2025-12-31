import java.util.*;

public class LeetCode1976 {
    private int MOD = (int)1e9 + 7;
    private class Pair implements Comparable<Pair>{
        int node;
        long time;
        Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
        @Override
        public int compareTo(Pair other) {
            return Long.compare(this.time, other.time);
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        long[] time = new long[n];
        int[] countWays = new int[n];
        Arrays.fill(time, Long.MAX_VALUE);
        Arrays.fill(countWays, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        time[0] = 0;
        countWays[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0));

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            long totalTime = pair.time;

            for(int[] adj : graph.get(node)) {
                long newTime = totalTime + adj[1];
                int nextNode = adj[0];
                if(newTime > time[nextNode]) continue;

                if(newTime < time[nextNode]) {
                    countWays[nextNode] = (countWays[node]) % MOD;
                    time[nextNode] = newTime;
                    pq.offer(new Pair(nextNode, time[nextNode]));
                }else if(newTime == time[nextNode]) {
                    countWays[nextNode] = (countWays[node] + countWays[nextNode]) % MOD;
                }
            }
        }
        return countWays[n - 1];
    }
}