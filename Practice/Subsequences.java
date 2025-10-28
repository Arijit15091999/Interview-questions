import java.util.*;

public class Subsequences {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4};
//        System.out.println(subsequences(arr));
//        System.out.println(subsequenceUsingPowerSet(arr));
//        System.out.println(subsequenceWithSumK(arr, 167));
//        System.out.println(subsequenceWithSumKButOnlyOneIsNeeded(arr, 4));
        System.out.println(subsequenceCounts(arr, 4));
    }

    public static ArrayList<String> subsequences(int[] arr) {
        ArrayList<String> res = new ArrayList<>();
        helper(arr, 0, new StringBuffer(), res);
        return res;
    }

    private static void helper(int[] arr, int index, StringBuffer stringBuffer, ArrayList<String> res) {
        if(index == arr.length) {
            res.add(stringBuffer.toString());
            return;
        }
        // O(2 ^ n)
        int num = arr[index];

        stringBuffer.append(num);
        // take
        helper(arr, index + 1, stringBuffer, res);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        // not take
        helper(arr, index + 1, stringBuffer, res);
    }

    public static ArrayList<ArrayList<Integer>> subsequenceUsingPowerSet(int[] arr) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList());

        for(int num : arr) {
            ArrayList<ArrayList<Integer>> subset = new ArrayList<>();
            for(ArrayList<Integer> list : arrayList) {
                ArrayList<Integer> temp = new ArrayList<>(list);
                temp.add(num);
                subset.add(temp);
            }
            arrayList.addAll(subset);
        }
        // O(nlog(n))
        return arrayList;
    }

    // print subsequences with sum k

    public static ArrayList<ArrayList<Integer>> subsequenceWithSumK(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        subsequenceWithSumKHelper(arr, 0,0, k, new ArrayList<Integer>(),res);
        return res;
    }

    private static void subsequenceWithSumKHelper(int[] arr, int index, int sum, int targetSum, ArrayList<Integer> subsequence,ArrayList<ArrayList<Integer>> res) {
        if(sum > targetSum) {
            return;
        }
        if(index == arr.length) {
            if(sum == targetSum) {
                res.add(new ArrayList<>(subsequence));
            }
            return;
        }
        int number = arr[index];
        // take
        subsequence.add(number);
        subsequenceWithSumKHelper(arr, index + 1, sum + number, targetSum, subsequence, res);
        subsequence.remove(subsequence.size() - 1);
        // not take
        subsequenceWithSumKHelper(arr, index + 1, sum, targetSum, subsequence, res);
    }

    // only one is needed
    public static ArrayList<ArrayList<Integer>> subsequenceWithSumKButOnlyOneIsNeeded(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        subsequenceWithSumKButOnlyOneIsNeededHelper(arr, 0,0, k,new ArrayList<Integer>(),res);
        return res;
    }
    private static boolean subsequenceWithSumKButOnlyOneIsNeededHelper(int[] arr, int index, int sum, int targetSum, ArrayList<Integer> subsequence,ArrayList<ArrayList<Integer>> res) {
        if(sum > targetSum) {
            return false;
        }
        if(index == arr.length) {
            if(sum == targetSum) {
                res.add(new ArrayList<>(subsequence));
                return true;
            }
            return false;
        }
        int number = arr[index];
        // take
        subsequence.add(number);
        boolean take = subsequenceWithSumKButOnlyOneIsNeededHelper(arr, index + 1, sum + number, targetSum, subsequence, res);
        subsequence.remove(subsequence.size() - 1);
        if(take) {
            return true;
        }
        // not take
        return subsequenceWithSumKButOnlyOneIsNeededHelper(arr, index + 1, sum, targetSum, subsequence, res);
    }

    // give the count with sum
    public static int subsequenceCounts(int[] arr, int k) {
        return helperForCount(arr, 0, 0, k);
    }
    private static int helperForCount(int[] arr, int index, int sum, int targetSum) {
        if(index == arr.length) {
            if(sum == targetSum) {
                return 1;
            }
            return 0;
        }
        int number = arr[index];
        // take
        int take = helperForCount(arr, index + 1, sum + number, targetSum);

        // not take
        int notTake = helperForCount(arr, index + 1, sum, targetSum);

        return take + notTake;
    }
}
