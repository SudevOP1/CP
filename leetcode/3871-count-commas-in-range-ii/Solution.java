
class Solution {

    public long countCommas(long n) {

        long ans = 0;
        for (long p = 1_000L; p <= 1_000_000_000_000_000L; p *= 1_000L) {
            if (n >= p) {
                ans += n - p + 1;
            }
        }

        return ans;
    }

}
