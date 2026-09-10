class Solution {

    public int countPartitions(int[] nums) {

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {

            int l = 0;
            for (int j = 0; j <= i; j++) {
                l += nums[j];
            }

            int r = 0;
            for (int j = i + 1; j < n; j++) {
                r += nums[j];
            }

            if ((l - r) % 2 == 0) {
                count += 1;
            }
        }

        return count;
    }

}
