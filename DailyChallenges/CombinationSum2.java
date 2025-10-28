import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, 0, target, candidates, new ArrayList<>(), res);
        return res;
    }
    private void helper(
            int index,
            int sum, int targetSum,
            int[] arr,
            List<Integer> ds,
            List<List<Integer>> res
    ) {
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
        helper(index + 1, sum + arr[index], targetSum, arr, ds, res);
        ds.remove(ds.size() - 1);

        while(index < arr.length - 1 && arr[index] == arr[index + 1]) {
            index++;
        }
        // not take
        helper(index + 1, sum, targetSum, arr, ds, res);
    }
}
