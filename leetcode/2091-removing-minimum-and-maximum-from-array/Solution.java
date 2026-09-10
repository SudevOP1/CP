import java.lang.Math;

class Solution {

    public int minimumDeletions(int[] nums) {

        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;

        // find index of min and max elems
        for (int i = 1; i < n; i++) {
            if (nums[minIndex] < nums[i]) {
                minIndex = i;
            }
            if (nums[maxIndex] > nums[i]) {
                maxIndex = i;
            }
        }

        // min and max are same elem, so removing elems from one side only
        if (minIndex == maxIndex) {
            return Math.min(minIndex + 1, (n - minIndex));
        }

        // removing elems from both sides
        int contendor1;
        if (minIndex < maxIndex) {
            contendor1 = (minIndex + 1) + (n - maxIndex);
        } else {
            contendor1 = (maxIndex + 1) + (n - minIndex);
        }

        // removing elems from left only
        int contendor2;
        if (minIndex < maxIndex) {
            contendor2 = maxIndex + 1;
        } else {
            contendor2 = minIndex + 1;
        }

        // removing elems from right only
        int contendor3;
        if (minIndex < maxIndex) {
            contendor3 = (n - minIndex);
        } else {
            contendor3 = (n - maxIndex);
        }

        return Math.min(Math.min(contendor1, contendor2), contendor3);
    }
}
