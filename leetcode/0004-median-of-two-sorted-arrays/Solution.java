
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;
        int prev = 0;
        int curr = 0;

        for (int count = 0; count <= (m + n) / 2; count++) {
            prev = curr;

            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
        }

        // final array's len = odd, so curr is the middle elem
        if ((m + n) % 2 != 0) {
            return curr;
        }

        // final array's len = even, so prev and curr are the two middles
        return (prev + curr) / (double) 2;
    }

}
