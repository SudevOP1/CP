import java.lang.StringBuilder;

class Solution {
    public static void setLongestSubstringPalindromIteration(String s, StringBuilder sb, int l, int r, int n) {

        while (0 <= l && r < n && s.charAt(l) == s.charAt(r)) {

            if (r + 1 - l > sb.length()) {
                sb.replace(0, sb.length(), s.substring(l, r + 1));
            }

            l--;
            r++;
        }
    }

    public String longestPalindrome(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder(s.substring(0, 1));

        for (int i = 0; i < n; i++) {

            // odd length palindromes
            setLongestSubstringPalindromIteration(s, sb, i, i, n);

            // even length palindroms
            setLongestSubstringPalindromIteration(s, sb, i, i + 1, n);
        }

        return sb.toString();
    }

}
