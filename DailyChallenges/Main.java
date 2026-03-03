import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int[] res = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int maxRooms = 0;

        for(int[] e : arr) {
            int start = e[0];
            int end = e[1];
            int day = e[2];

            if(pq.isEmpty()) {
                pq.offer(new int[]{1, end + 1});
                res[day] = 1;
            }else {
                int[] peek = pq.peek();
                if(start >= peek[1]) {
                    pq.poll();
                    res[day] = peek[0];
                    pq.offer(new int[]{peek[0], end + 1});
                }else {
                    int size = pq.size();
                    pq.offer(new int[]{size + 1, end + 1});
                    res[day] = size + 1;
                }
            }
            maxRooms = Math.max(maxRooms, pq.size());
        }

        System.out.println(maxRooms);
        for(int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
