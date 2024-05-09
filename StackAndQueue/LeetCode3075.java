import java.util.*;

public class LeetCode3075 {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
    }
    public static long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        int level = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer h : happiness) {
            pq.offer(h);
        }

        while(k > 0) {
            int val = pq.poll() - level;
            if(val < 0) break;
            sum += val;
            level++;
            k--;
        }
        return sum;
    }
}
