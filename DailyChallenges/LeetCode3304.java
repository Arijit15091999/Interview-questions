
public class LeetCode3304 {
    public char kthCharacter(int k) {
        int numberOfShifts = 0;
        int index = k - 1;
        while(index != 0) {
            int remainder = index % 2 != 0 ? 1 : 0;
            if(remainder == 1) {
                numberOfShifts++;
            }
            index =  index / 2;
        }

        return (char)('a' + numberOfShifts);
    }
//    private char helper(String str, int k) {
//        if(str.length() >= k) {
//            return str.charAt(k - 1);
//        }
//
//        StringBuffer sb = new StringBuffer();
//        sb.append(str);
//        for(char c : str.toCharArray()) {
//            char nextCharacter = (char)('a' + (c - 'a' + 1) % 26);
//            sb.append(nextCharacter);
//        }
//        return helper(sb.toString(), k);
//    }
}
