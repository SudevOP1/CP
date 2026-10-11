import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] pivotArray(int[] nums, int pivot) {

        int n = nums.length;
        int[] ans = new int[n];
        int pivotCount = 0;
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (nums[i] < pivot) {
                l.add(nums[i]);
            }

            else if (nums[i] > pivot) {
                r.add(nums[i]);
            }

            else {
                pivotCount += 1;
            }
        }

        int lSize = l.size();
        int rSize = r.size();
        for (int i = 0; i < lSize; i++) {
            ans[i] = l.get(i);
        }
        for (int i = 0; i < pivotCount; i++) {
            ans[i + lSize] = pivot;
        }
        for (int i = 0; i < rSize; i++) {
            ans[i + lSize + pivotCount] = r.get(i);
        }

        return ans;
    }

}
