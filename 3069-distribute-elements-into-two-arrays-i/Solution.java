class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = nums[0];
        arr2[0] = nums[1];

        // create arr1 & arr2
        int arr1CurrentIndex = 1;
        int arr2CurrentIndex = 1;
        for (int i = 2; i < n; i++) {

            if (arr1[arr1CurrentIndex - 1] > arr2[arr2CurrentIndex - 1]) {
                arr1[arr1CurrentIndex] = nums[i];
                arr1CurrentIndex += 1;
            } else {
                arr2[arr2CurrentIndex] = nums[i];
                arr2CurrentIndex += 1;
            }
        }

        // concat arrays
        for (int i = 0; i < arr2CurrentIndex; i++) {
            arr1[i + arr1CurrentIndex] = arr2[i];
        }

        return arr1;
    }
}
