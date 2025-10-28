import java.util.*;
public class LeetCode698 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,2,2,2,2};
        LeetCode698 l = new LeetCode698();
        System.out.println(l.canPartitionKSubsets(arr, 4));
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int[] count = new int[]{0};
        int sum = 0;
        for(Integer num : nums) {
            sum += num;
        }

        int bucketSum = sum / k;

        if(sum % k != 0) {
            return false;
        }

        helper(0, 0, bucketSum, nums, count);
        return count[0] >= k;
    }

    private void helper(int index, int sum, int targetSum, int[] arr, int[] count) {
        if(index == arr.length) {
            if(sum == targetSum)
                count[0]++;
            return;
        }
        // take
        helper(index + 1, sum + arr[index], targetSum, arr, count);
        // not take
//        while(index < arr.length - 1 && arr[index] == arr[index + 1]) index++;
        helper(index + 1, sum, targetSum, arr, count);

    }

}
