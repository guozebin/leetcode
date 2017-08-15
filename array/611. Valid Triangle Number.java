//
// TIME LIMIT EXCEEDED
//
public class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k] &&
                        Math.abs(nums[i] - nums[j]) < nums[k] &&
                        nums[j] + nums[k]> nums[i] &&
                        Math.abs(nums[j] - nums[k]) < nums[i] &&
                        nums[i] + nums[k] > nums[j] &&
                        Math.abs(nums[i] - nums[k]) < nums[j]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}