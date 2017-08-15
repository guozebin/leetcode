public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        int outerBound = nums.length - 1;
        int innerBound = nums.length;
        
        for (int i = 0; i < outerBound; i++) {
            indices[0] = i;
            for (int j = i + 1; j < innerBound; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }
}