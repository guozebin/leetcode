public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int b = nums[0] * nums[nums.length - 1] * nums[nums.length - 2];
        int c = nums[0] * nums[1] * nums[2];
        int d = nums[0] * nums[1] * nums[nums.length - 1];
        a = a > b ? a : b;
        c = c > d ? c : d;
        
        return a > c ? a : c; 
    }
}