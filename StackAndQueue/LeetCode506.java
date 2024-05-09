import java.util.*;

public class LeetCode506 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }
    private static class Pair implements Comparable<Pair>{
        int index, score;
        Pair(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Pair o) {
            return this.score - o.score;
        }
    }
    public static String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        String[] res = new String[score.length];
        int n = score.length;

        for(int i = 0; i < n; i++) {
            pq.offer(new Pair(i, score[i]));
        }

        String[] ranks = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

        for(int i = 0; i < n; i++) {
            Pair pair = pq.remove();
            if(i < 3) {
                res[pair.index] = ranks[i];
            }else{
                res[pair.index] = i + 1 + "";
            }
        }

        return res;
    }
}
