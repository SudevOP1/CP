import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ansList = new ArrayList<>();
        int ansCount = 0;

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    found = true;
                    break;
                }
            }
            if (found) {
                ansList.add(nums[i]);
                ansCount += 1;
            }
        }
        int[] ans = new int[ansCount];
        for (int i = 0; i < ansCount; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
