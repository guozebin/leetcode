// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
// Note:
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
// The number of elements initialized in nums1 and nums2 are m and n respectively.
//
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums3[] = new int[m];
        int i = 0, j = 0, k = 0;

        // 先拷贝短的数组，直接赋值到 nums1，后期不需要拷贝
        System.arraycopy(nums1, 0, nums3, 0, m);
        while (j < m && k < n) {
            if (nums3[j] > nums2[k])
                nums1[i++] = nums2[k++];
            else
                nums1[i++] = nums3[j++];
        }
        if (j < m) {
            System.arraycopy(nums3, j, nums1, i, m - j);
        }
        if (k < n) {
            System.arraycopy(nums2, k, nums1, i, n - k);
        }       
    }
}