
class Solution {

    private char[] sc, tc;
    private int[][] cache;

    private int count(int sIndex, int tIndex) {

        if (tIndex == tc.length) {
            return 1;
        }

        if (sc.length - sIndex < tc.length - tIndex) {
            return 0;
        }

        // cache hit
        if (cache[sIndex][tIndex] != -1) {
            return cache[sIndex][tIndex];
        }

        // cache miss
        int numDistinct = count(sIndex + 1, tIndex);
        if (sc[sIndex] == tc[tIndex]) {
            numDistinct += count(sIndex + 1, tIndex + 1);
        }
        cache[sIndex][tIndex] = numDistinct;

        return numDistinct;
    }

    public int numDistinct(String s, String t) {

        // edge case
        if (s.length() < t.length()) {
            return 0;
        }

        sc = s.toCharArray();
        tc = t.toCharArray();

        cache = new int[sc.length][tc.length];
        for (int i = 0; i < s.length(); i++) {
            cache[i] = new int[t.length()];
            for (int j = 0; j < t.length(); j++) {
                cache[i][j] = -1;
            }
        }

        return count(0, 0);
    }

}
