import java.util.Arrays;

public class Leetcode151 {
    public static String reverseWords(String str) {
        String s = str.trim();
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        int n = arr.length;

//        System.out.println(!arr[2].equals(""));

        for(int i = n - 1; i >= 0; i--) {
            if(!arr[i].equals(""))
                sb.append(arr[i] + " ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
