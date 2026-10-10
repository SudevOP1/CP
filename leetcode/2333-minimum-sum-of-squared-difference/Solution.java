
class Solution {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;

        int maxDiff = 0;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
        }

        long[] count = new long[maxDiff + 1];
        for (int d : diffs) {
            count[d]++;
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (count[d] <= k) {
                k -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                count[d] -= k;
                count[d - 1] += k;
                k = 0;
            }
        }

        long sum = 0;
        for (int d = 1; d <= maxDiff; d++) {
            sum += count[d] * d * d;
        }
        return sum;
    }

}
