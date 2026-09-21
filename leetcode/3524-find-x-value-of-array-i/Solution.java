
class Solution {

    int[][] cache;

    public long[] resultArray(int[] nums, int k) {

        int n = nums.length;
        long[] answer = new long[k];
        cache = new int[n][k];

        for (int i = 0; i < n; i++) {

            int val = nums[i] % k;

            cache[i][val]++;

            if (i > 0) {
                for (int j = 0; j < k; j++) {
                    if (cache[i - 1][j] > 0) {
                        cache[i][(j * val) % k] += cache[i - 1][j];
                    }
                }
            }

            for (int j = 0; j < k; j++) {
                answer[j] += cache[i][j];
            }
        }

        return answer;
    }

}
