import java.util.Arrays;

class Solution {

    int mod = 1_000_000_000 + 7;
    int[] cache = new int[2001];
    int[] prev = new int[2001];

    private int count(int i) {

        if (i == 0) {
            return 1;
        }

        // cache hit
        if (cache[i] != -1) {
            return cache[i];
        }

        int total = (2 * count(i - 1)) % mod;

        if (prev[i] != 0) {
            int dups = count(prev[i] - 1);
            total = (total - dups + mod) % mod;
        }

        cache[i] = total; // memoization
        return total;
    }

    public int distinctSubseqII(String s) {

        int n = s.length();
        Arrays.fill(cache, -1);

        int[] lastSeen = new int[26];
        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }

        return (count(n) - 1 + mod) % mod;
    }

}
