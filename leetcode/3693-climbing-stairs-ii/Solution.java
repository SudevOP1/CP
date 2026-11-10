
class Solution {

    public int climbStairs(int n, int[] costs) {

        int[] cache = new int[n + 1];
        cache[0] = 0;

        for (int j = 1; j <= n; j++) {
            int best = Integer.MAX_VALUE;
            for (int k = 1; k <= 3 && j - k >= 0; k++) {
                best = Math.min(best, cache[j - k] + k * k);
            }
            cache[j] = best + costs[j - 1];
        }

        return cache[n];
    }

}
