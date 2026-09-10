
class Solution {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i != n) {
            if (nums[i] != nums[j]) {
                nums[j + 1] = nums[i];
                j++;
                k++;
            }
            i++;
        }

        return k + 1;
    }

}
