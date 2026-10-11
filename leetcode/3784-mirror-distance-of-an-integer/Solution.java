
class Solution {

    private static int reverse(int n) {

        int ans = 0;
        int N = n;
        int numDigits = 0;

        while (N != 0) {
            N /= 10;
            numDigits += 1;
        }

        for (int i = 0; i < numDigits; i++) {
            int digit = n % 10;
            ans += digit * Math.pow(10, numDigits - i - 1);
            n /= 10;
        }

        return ans;
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

}
