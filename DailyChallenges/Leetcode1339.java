import java.util.ArrayList;
import java.util.List;


public class Leetcode1339 {
    private int MOD = (int)1e9 + 7;
    public int maxProduct(TreeNode root) {
        List<Long> dp = new ArrayList<>();
        long ans = 0;
        long sum = sum(root, dp);

        for(Long sumSet : dp) {
            long mul = sumSet * (sum - sumSet);
            ans = Math.max(ans, mul);
        }
        return (int)(ans % MOD);
    }
    private long sum(TreeNode node, List<Long> dp) {
        if(node == null) {
            return 0;
        }
        long left  = sum(node.left, dp);
        long right = sum(node.right, dp);
        long val = node.val + left + right;
        if(val > 0)
            dp.add(val);
        return val;
    }
}
