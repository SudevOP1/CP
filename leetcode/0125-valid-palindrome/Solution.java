
class Solution {

    private static boolean isAlphaNumeric(char c) {
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }

    public boolean isPalindrome(String s) {

        int n = s.length();
        boolean isPalindrome = true;
        s = s.toLowerCase();

        int l = 0;
        int r = n - 1;

        while (l < r) {
            while (l < n && !isAlphaNumeric(s.charAt(l))) {
                l += 1;
            }
            while (0 <= r && !isAlphaNumeric(s.charAt(r))) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            if (s.charAt(l) != s.charAt(r)) {
                isPalindrome = false;
                break;
            }

            l += 1;
            r -= 1;
        }

        return isPalindrome;
    }

}
