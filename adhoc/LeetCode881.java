import java.util.*;

public class LeetCode881 {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 8, 7, 1, 4}, 9));
    }
    public static int numRescueBoats(int[] people, int limit) {
        int i = 0, j = people.length - 1;
        int res = 0;
        Arrays.sort(people);

        while(i <= j) {
            if(i != j && people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            res++;
        }

        return res;
    }
}
