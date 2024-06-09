public class SingleElement {
    public static void main(String[] args) {
        int[] arr = {3, 3, 10, 11, 11};
        System.out.println(singleNonDuplicate(arr));
    }
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        if (n == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        int start = 1, end = n - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return mid;
            }
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
