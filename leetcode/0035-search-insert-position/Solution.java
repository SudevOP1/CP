
class Solution {

    public int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int l = 0;
        int r = n;

        while (l < r) {
            int c = l + (r - l) / 2;
            if (nums[c] < target) {
                l = c + 1;
            } else {
                r = c;
            }
        }

        return l;
    }

}
