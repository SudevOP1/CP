import java.util.Arrays;

class Solution {

    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        final int INF = Integer.MAX_VALUE / 2;

        int[] best = new int[n];
        Arrays.fill(best, INF);

        int ans = INF;
        int sum = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {

            sum += arr[r];

            while (sum > target) {
                sum -= arr[l++];
            }

            if (sum == target) {
                int len = r - l + 1;
                if (l > 0) {
                    ans = Math.min(ans, best[l - 1] + len);
                }
                best[r] = len;
            }

            if (r > 0) {
                best[r] = Math.min(best[r], best[r - 1]);
            }
        }

        return ans >= INF ? -1 : ans;
    }

}
