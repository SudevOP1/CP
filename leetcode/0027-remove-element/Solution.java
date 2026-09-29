
class Solution {

    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        int removed = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[removed] = nums[i];
                removed += 1;
            }
        }

        return removed;
    }

}
