class Solution {

    public static int max(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        }
        return n2;
    }

    public int stoneGameVIII(int[] stones) {

        int n = stones.length;
        int[] prevSums = new int[n];
        int[] scores = new int[n];

        prevSums[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prevSums[i] = stones[i] + prevSums[i - 1];
        }

        scores[n - 1] = prevSums[n - 1];
        for (int i = n - 1; i > 1; i--) {
            scores[i - 1] = max(scores[i], prevSums[i - 1] - scores[i]);
        }

        return scores[1];

    }
}
