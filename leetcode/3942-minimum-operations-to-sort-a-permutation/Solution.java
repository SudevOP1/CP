
class Solution {

    public int minOperations(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }
        }

        // strictly ascending
        boolean isStrictlyAscending = true;
        for (int i = minIndex; nums[(i + 1) % n] != nums[minIndex]; i = (i + 1) % n) {
            if (nums[i] > nums[(i + 1) % n]) {
                isStrictlyAscending = false;
                break;
            }
        }
        if (isStrictlyAscending) {
            System.out.println("isStrictlyAscending");
            return Math.min(minIndex, n - minIndex + 2);
        }

        // strictly descending
        boolean isStrictlyDescending = true;
        for (int i = minIndex; nums[(i - 1 + n) % n] != nums[minIndex]; i = (i - 1 + n) % n) {
            if (nums[i] > nums[(i - 1 + n) % n]) {
                isStrictlyDescending = false;
                break;
            }
        }
        if (isStrictlyDescending) {
            System.out.println("isStrictlyDescending");
            return Math.min(minIndex + 2, n - minIndex);
        }

        return -1;
    }

}
