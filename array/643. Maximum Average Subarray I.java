//
// Sliding window algorithm
// 只要计算一次，时间为 O(N)
// 如果采用朴素算法，时间为O(N^2)
//
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0, sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for (int i = 0, r = k; r < nums.length; i++, r++) {
            sum = sum - nums[i] + nums[r];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum / k;
    }
}