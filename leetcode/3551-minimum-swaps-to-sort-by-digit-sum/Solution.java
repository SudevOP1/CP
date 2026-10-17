import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int minSwaps(int[] nums) {

        int n = nums.length;
        int[] sums = new int[n];
        boolean[] visited = new boolean[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        // calc sums
        for (int i = 0; i < n; i++) {

            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            sums[i] = sum;
        }

        // sort indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> {
            if (sums[i] != sums[j]) {
                return Integer.compare(sums[i], sums[j]);
            }
            return Integer.compare(nums[i], nums[j]);
        });

        // get targetPositions
        int[] targetPositions = new int[n];
        for (int pos = 0; pos < n; pos++) {
            targetPositions[indices[pos]] = pos;
        }

        // count cycles
        int cycles = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {

                cycles++;
                int j = i;

                while (!visited[j]) {
                    visited[j] = true;
                    j = targetPositions[j];
                }
            }
        }

        return n - cycles;
    }

}
