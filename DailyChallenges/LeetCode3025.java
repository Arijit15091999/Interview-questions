import java.util.Arrays;
import java.util.Comparator;

public class LeetCode3025 {
    public int numberOfPairs(int[][] points) {
       ; Arrays.sort(points, (a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(b[1], a[1]);
        });
        int ans = 0;
        int n = points.length;

        for(int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1], yMax = -(int)1e9;
            for(int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                if(y2 > yMax && y1 >= y2) {
                    ans++;
                    yMax = y2;
                }
            }
        }

        return ans;
    }
}
