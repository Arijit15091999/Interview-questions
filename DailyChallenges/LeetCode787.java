import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode787 {
    private class Tuple implements Comparable<Tuple>{
        int node;
        int numberOfNodes;
        int price;
        Tuple(int node, int numberOfNodes, int price) {
            this.node = node;
            this.numberOfNodes = numberOfNodes;
            this.price = price;
        }
        @Override
        public int compareTo(Tuple other) {
            return this.price - other.price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        pq.offer(new Tuple(src, 1, 0));

        while(!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            int node = tuple.node;
            int numberOfHops = tuple.numberOfNodes;
            int price = tuple.price;
            for(int[] adj : graph.get(node)) {
                int newPrice = price + adj[1];
                int nextNode = adj[0];
                if(numberOfHops + 1 <= k + 2 && newPrice < dis[nextNode]) {
                    dis[nextNode]  = newPrice;
                    pq.offer(new Tuple(nextNode, numberOfHops + 1, newPrice));
                }
            }
        }
        System.out.println(Arrays.toString(dis));
        return dis[dst];
    }
}
