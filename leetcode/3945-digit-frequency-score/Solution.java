
class Solution {

    public int digitFrequencyScore(int n) {

        char[] digits = String.valueOf(n).toCharArray();
        int ans = 0;

        for (int i = 0; i < digits.length; i++) {
            ans += digits[i] - '0';
        }

        return ans;
    }

}
