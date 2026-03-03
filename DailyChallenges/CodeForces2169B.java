import java.util.*;

public final class CodeForces2169B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String str = sc.nextLine();
            int n = str.length();
            boolean notPossible = false;
            int countLeft = 0;
            int countRight = 0;

            for(int i = 0; i < n - 1; i++) {
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(i + 1);
                if(ch1 != '<' && ch2 != '>') {
                    System.out.println(-1);
                    notPossible = true;
                    break;
                }
            }
            for(int i = 0; i < n && !notPossible ; i++) {
                char ch1 = str.charAt(i);
                if(ch1 == '>') countRight++;
                if(ch1 == '<') countLeft++;
            }
            if(!notPossible)
                System.out.println(n - Math.min(countLeft, countRight));
        }
    }
}
