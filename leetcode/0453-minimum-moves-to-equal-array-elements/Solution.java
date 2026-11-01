
class Solution {

    public int minMoves(int[] nums) {

        int n = nums.length;
        int min = nums[0];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (min > nums[i]) {
                ans += (min - nums[i]) * i;
                min = nums[i];
            } else {
                ans += nums[i] - min;
            }
        }

        return ans;
    }

}
