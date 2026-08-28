class Solution {

    public int missingMultiple(int[] nums, int k) {

        int n = nums.length;

        for (int multiple = 1; true; multiple++) {

            boolean found = false;

            for (int ind = 0; ind < n; ind++) {
                if (k * multiple == nums[ind]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return k * multiple;
            }
        }

    }
}
