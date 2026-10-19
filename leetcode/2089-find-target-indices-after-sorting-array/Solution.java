import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {

        int n = nums.length;
        int numTarget = 0;
        int numLower = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                numTarget += 1;
            }
            if (nums[i] < target) {
                numLower += 1;
            }
        }

        List<Integer> targetIndices = new ArrayList<>();
        for (int i = 0; i < numTarget; i++) {
            targetIndices.add(numLower + i);
        }

        return targetIndices;
    }

}
