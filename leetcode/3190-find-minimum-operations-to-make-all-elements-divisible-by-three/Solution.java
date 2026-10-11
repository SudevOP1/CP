
class Solution {

    public int minimumOperations(int[] nums) {

        int n = nums.length;
        int numOperations = 0;

        for (int i = 0; i < n; i++) {
            numOperations += nums[i] % 3 == 0 ? 0 : 1;
        }

        return numOperations;
    }

}
