void merge(int* nums1, int m, int* nums2, int n) {
    int nums3[m + n];
    int i = 0; j = 0; k = 0;

    while (j < m && k < n) {
        if (nums1[j] > nums2[k]) {
            nums3[i++] = nums2[k++];
        } else {
            nums3[i++] = nums1[j++];
        }
    }
    while (j < m) {
        nums3[i++] = nums1[j++];
    }
    while (k < n) {
        nums3[i++] = nums2[k++];
    }
    i = 0;
    while (i < m + n) {
        nums1[i] = nums3[i];
        i++;
    }
}