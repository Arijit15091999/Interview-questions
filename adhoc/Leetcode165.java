public class Leetcode165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.0", "1.0.0"));
    }
    public static int compareVersion(String version1, String version2) {
        int res = 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int size = Math.min(v1.length, v2.length);

//        System.out.println(size);

        for(int i = 0; i < size; i++) {
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[i]);

//            System.out.println(num1);
//            System.out.println(num2);

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
}
