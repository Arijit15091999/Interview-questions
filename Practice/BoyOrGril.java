import java.util.Arrays;
import java.util.Scanner;

public class BoyOrGril {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        boolean[] map = new boolean[26];
        Arrays.fill(map, false);
        for(char ch : userName.toCharArray()) {
            map[ch - 'a'] = true;
        }

        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(map[i]) count++;
        }
        String verdict = count % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!";
        System.out.println(verdict);
    }
}
