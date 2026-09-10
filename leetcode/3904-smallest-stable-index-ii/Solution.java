import java.util.HashMap;
import java.util.Map;

class Solution {

    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> minMap = new HashMap<>();

        // edge cases
        if (n == 1) {
            return 0;
        }

        // create minMap
        int curMin = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (curMin > nums[i]) {
                curMin = nums[i];
            }
            minMap.put(i, curMin);
        }

        // iterate to find instability score
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
