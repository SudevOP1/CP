
class Solution {

    public int countMonobit(int n) {
        if (n <= 1) {
            return n + 1;
        }
        int numDigits = Integer.toBinaryString(n).length();
        return numDigits + ((Integer.parseUnsignedInt("1".repeat(numDigits), 2) <= n) ? 1 : 0);
    }

}
