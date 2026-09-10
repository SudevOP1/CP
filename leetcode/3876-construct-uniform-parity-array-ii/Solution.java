class Solution {

    public boolean uniformArray(int[] nums1) {

        int n = nums1.length;
        int smallestOdd = nums1[0];

        // already strictly odd or even case
        boolean firstElemEven = nums1[0] % 2 == 0;
        boolean pass = true;
        for (int i = 1; i < n; i++) {
            if ((firstElemEven && nums1[i] % 2 != 0) || (!firstElemEven && nums1[i] % 2 == 0)) {
                pass = false;
                break;
            }
        }
        if (pass) {
            return true;
        }

        // get smallestOdd
        for (int i = 1; i < n; i++) {
            if (nums1[i] % 2 != 0 && nums1[i] < smallestOdd) {
                smallestOdd = nums1[i];
            }
        }

        // check for complete even
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 != 0 && nums1[i] - smallestOdd < 1) {
                pass = false;
                break;
            }
        }
        if (pass) {
            return true;
        }

        // check for complete odd
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 == 0 && nums1[i] - smallestOdd < 1) {
                return false;
            }
        }

        return true;
    }
}
