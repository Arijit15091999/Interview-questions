public class LeetCode1903 {
    public static String largestOddNumber(String num) {
        int n = num.length();

        int start = -1, end = -1;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if((ch + 0) % 2 != 0) {
                if(start == -1) start = i;
                end = i;
            }
        }

        return start == -1 ? "" : num.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("4206"));
    }
}
