import java.util.*;

public class CombinationalSum1 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5};
        int target = 8;
        CombinationalSum1 com = new CombinationalSum1();
        System.out.println(com.combinationSum(arr, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, 0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private void helper(
        int index,
        int sum,
        int targetSum,
        int[] arr,
        List<Integer> ds,
        List<List<Integer>> res
    ){
        if(sum > targetSum) {
            return;
        }
        if(sum == targetSum) {
            res.add(new ArrayList<>(ds));
            return;
        }
        if(index == arr.length) {
            return;
        }
        // take
        ds.add(arr[index]);
        helper(index, sum + arr[index], targetSum, arr, ds, res);
        ds.remove(ds.size() - 1);
        // not take
        helper(index + 1, sum, targetSum, arr, ds, res);
    }
}
