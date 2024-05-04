public class Leetcode165 {
    public static void main(String[] args) {
        System.out.println(compareVersionOptimal("1.0", "1.0.0"));
    }
    public static int compareVersion(String version1, String version2) {
        int res = 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int size = Math.min(v1.length, v2.length);


        for(int i = 0; i < size; i++) {
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[i]);


            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }

        if(v1.length > v2.length) {
            for(int index = size; index < v1.length; index++) {
                int num = Integer.parseInt(v1[index]);
                if(num != 0) return 1;
            }
        }

        if(v1.length < v2.length) {
            for(int index = size; index < v2.length; index++) {
                int num = Integer.parseInt(v2[index]);
                if(num != 0) return -1;
            }
        }

        return res;
    }

    public static int compareVersionOptimal(String version1, String version2) {
        int i = 0, j = 0;

        while(i < version1.length() || j < version2.length()) {
            int num1 = 0, num2 = 0;
            while(i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i++) - '0';
            }

            while(j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j++) - '0';
            }


            if(num1 > num2) return 1;
            else if(num1 < num2) return -1;
            i++;
            j++;
         }
        return 0;
    }
}
