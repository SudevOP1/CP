
class Solution {

    private static final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {

        int n = arr.length;
        long ans = 0;
        int even = 1;
        int odd = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if ((sum & 1) == 1) {
                ans += even;
                odd++;
            } else {
                ans += odd;
                even++;
            }
        }

        return (int) (ans % MOD);
    }
}
