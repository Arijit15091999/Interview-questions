import java.util.*;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();

        helper(1, 0, k, n, subSet, ans);

        return ans;
    }

    public void helper(int i, int sum, int k, int n, List<Integer> subSet, List<List<Integer>> ans) {

        if(sum > n)return;

        if(k == 0){
            if(sum == n){
                ans.add(new ArrayList(subSet));
            }
            return;
        }

        if(i > 9) return;

        subSet.add(i);
        helper(i + 1, sum + i, k - 1, n, subSet, ans);
        subSet.remove(subSet.size() - 1);

        helper(i + 1, sum, k, n, subSet, ans);
    }
}
