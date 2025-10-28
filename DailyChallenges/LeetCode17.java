import java.util.*;

public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        char[][] mappings = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) {
            return res;
        }
        helper(0, digits, new StringBuilder(), mappings, res);
        return res;
    }

    private void helper(int index, String digits, StringBuilder sb, char[][] mappings, List<String> res) {
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        char[] possibleChars = mappings[Integer.parseInt(digit + "") - 2];

        for(char c : possibleChars) {
            sb.append(c + "");
            helper(index + 1, digits, sb, mappings, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
