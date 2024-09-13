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

    // follow up if string is mutable

    public static String reverseWordsForMutableStrings(String str) {
        char[] arr = str.toCharArray();

        int i = 0, j = 0;

        while(j < arr.length) {
            if((arr[j] == ' ')) {
                j++;
            }else{
                if(i > 0) {
                    arr[i] = ' ';
                    i++;
                }
                arr[i] = arr[j];
                i++;
                j++;
            }
        }

        while(i < arr.length) {
            arr[i++] = ' ';
        }

        i = 0;
        j = 0;

        while(j < arr.length) {
            if(arr[j] != ' ') {
                j++;
            }else{
                reverseString(arr, i, j);
                j++;
                i = j;
            }
        }

        return new String(arr).trim();
    }

    private static void reverseString(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start ] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        System.out.println(reverseWordsForMutableStrings("a good   example"));
    }
}
