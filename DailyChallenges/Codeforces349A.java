import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Codeforces349A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] nums = sc.nextLine().trim().split(" ");
        int[] arr = new int[n];
        int index = 0;
        for(String num : nums) {
            arr[index++] = Integer.parseInt(num);
        }
        String ans = solve(n, arr) ? "YES" : "NO";
        System.out.println(ans);
    }
    private static boolean solve(int n, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] bills = new int[]{25, 50, 100};
        for(int bill : bills) {
            map.put(bill, 0);
        }
        for(Integer bill : arr) {
            if(bill == 25) {
                map.put(25, map.getOrDefault(25, 0) + 1);
            }else if(bill == 50) {
                int count = map.getOrDefault(25, 0);
                if (count < 1) {
                    return false;
                }
                map.put(50, map.getOrDefault(50, 0) + 1);
                map.put(25, count - 1);
            }else {
                if(map.get(25) >= 1 && map.get(50) >= 1) {
                    map.put(25, map.get(25) - 1);
                    map.put(50, map.get(50) - 1);
                }else if(map.get(25) >= 3) {
                    map.put(25, map.get(25) - 3);
                }else {
                    return false;
                }
                map.put(100, map.getOrDefault(100, 0) + 1);
            }
        }
        return true;
    }
}
