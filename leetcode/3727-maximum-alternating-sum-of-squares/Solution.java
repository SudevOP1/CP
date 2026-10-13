import java.util.Arrays;

class Solution {

    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        int l = 0;
        int r = n - 1;

        while (l < r) {
            ans += nums[r] - nums[l];
            l++;
            r--;
        }
        if (l == r) {
            ans += nums[l];
        }

        return ans;
    }

}
