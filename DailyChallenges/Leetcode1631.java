import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode1631 {
    private int[] rowDis = new int[]{-1, 0, 1, 0};
    private int[] colDis = new int[]{0, 1, 0, -1};
    private class Tuple implements Comparable<Tuple>{
        int row;
        int col;
        int effort;
        Tuple(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.effort - o.effort;
        }
    }
    private boolean isValid(int row, int col, int[][] arr) {
        return row >= 0 && col >= 0 && row < arr.length && col < arr[0].length;
    }
    public int minimumEffortPath(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int[][] dis = new int[n][m];
        for(int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        pq.offer(new Tuple(0, 0, 0));

        while(!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            int row = tuple.row;
            int col = tuple.col;
            int effort = tuple.effort;

            for(int i = 0; i < 4; i++) {
                int newRow = row + rowDis[i];
                int newCol = col + colDis[i];
                if(isValid(newRow, newCol, arr)) {
                    int pathEffort = Math.max(effort, Math.abs(arr[newRow][newCol] - arr[row][col]));
                    if(pathEffort < dis[newRow][newCol]) {
                        dis[newRow][newCol] = pathEffort;
                        pq.offer(new Tuple(newRow, newCol, pathEffort));
                    }
                }
            }
        }
        return dis[n - 1][m - 1];
    }
}
