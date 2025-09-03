import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode1792{
    class Pair implements Comparable<Pair> {
        int pass, total;

        public Pair(int[] arr) {
            this.pass = arr[0];
            this.total = arr[1];
        }

        public void addStudent() {
            this.pass += 1;
            this.total += 1;
        }

        public double getPassRatio() {
            return this.pass / (double)this.total;
        }

        public double getEntropy() {
            return (this.pass + 1) / (double)(this.total + 1) - this.getPassRatio();
        }

        @Override
        public int compareTo(Pair other) {
            double delta = this.getEntropy() - other.getEntropy();
            return delta == 0 ? 0 :
                    (delta > 0) ? 1 : -1;

        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Collections.reverseOrder());

        for(int[] c : classes) {
            Pair pair = new Pair(c);
            pq.offer(pair);
        }

        while(extraStudents > 0) {
            Pair pair = pq.poll();
            pair.addStudent();
            pq.offer(pair);

            extraStudents -= 1;
        }

        double result = 0.0;
        int totalNumberOfClasses = classes.length;

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            result += pair.getPassRatio();
        }

        return result / totalNumberOfClasses;
    }

}
