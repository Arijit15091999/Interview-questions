// https://leetcode.com/problems/reverse-prefix-of-word/submissions/
public class LeetCode2000 {
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        if (index == -1) {
            return word;
        }

        return word.substring(0, index + 1) + word.substring(index + 1);
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
