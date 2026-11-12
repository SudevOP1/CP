
class Solution {

    public int longestMonotonicSubarray(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 1;
        }

        int max = 1;
        int cur = 1;
        boolean curInc = nums[1] > nums[0];

        for (int i = 1; i < n; i++) {

            // current streak continues
            if ((curInc && nums[i] > nums[i - 1]) || (!curInc && nums[i] < nums[i - 1])) {
                cur += 1;
            }

            // reset
            else {
                if (nums[i] > nums[i - 1]) {
                    curInc = true;
                }
                if (nums[i] < nums[i - 1]) {
                    curInc = false;
                }
                cur = (nums[i] == nums[i - 1]) ? 1 : 2;
            }

            max = Math.max(max, cur);
        }

        return max;
    }

}
