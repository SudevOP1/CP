import java.util.Arrays;

class Solution {

    public int sortPermutation(int[] nums) {

        int n = nums.length;
        int[] nums1 = nums.clone();
        Arrays.sort(nums1);

        int ans = Integer.MAX_VALUE;
        boolean isSame = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != nums1[i]) {
                ans &= nums[i];
                isSame = false;
            }
        }
        if (isSame) {
            return 0;
        }

        return ans;
    }

}
