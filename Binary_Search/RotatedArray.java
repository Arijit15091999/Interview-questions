public class RotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[] {2, 3, 4, 5, 6, 7, 8,9 ,1}, 1));
    }
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] >= nums[start]) {
                // we are in the left sorted array
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
}
