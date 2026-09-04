import java.util.HashMap;
import java.util.Map;

class Solution {

    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> minMap = new HashMap<>();

        int curMin = nums[n - 1];
        minMap.put(n - 1, nums[n - 1]);

        // store minimum value to the right of each elem in minMap
        for (int i = n - 2; i >= 0; i--) {
            if (curMin > nums[i]) {
                curMin = nums[i];
            }
            minMap.put(i, curMin);
        }

        // iterate to find smallestStableIndex
        int curMax = nums[0];
        for (int i = 0; i < n; i++) {
            if (curMax < nums[i]) {
                curMax = nums[i];
            }
            if (curMax - minMap.get(i) <= k) {
                return i;
            }
        }

        return -1;
    }

}
