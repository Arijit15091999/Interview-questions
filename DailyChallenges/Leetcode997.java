public class Leetcode997 {
    public int findJudge(int n, int[][] trust) {
        int[] t = new int[n + 1];

        for(int[] tru : trust) {
            int a = tru[0];
            int b = tru[1];

            t[a]--;
            t[b]++;
        }

        for(int i = 1; i <= n; i++) {
            if(t[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
