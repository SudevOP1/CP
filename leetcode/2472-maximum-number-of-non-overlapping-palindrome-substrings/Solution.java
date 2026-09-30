
class Solution {

    private boolean checkPalindrome(String s, int start, int end) {

        int l = start;
        int r = end;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public int maxPalindromes(String s, int k) {

        int n = s.length();
        int count = 0;
        int start = 0;

        if (k > n) {
            return 0;
        }

        for (int i = k - 1; i < n; i++) {

            int l1 = i - k + 1;
            int l2 = i - k;

            boolean p1 = l1 >= start && checkPalindrome(s, l1, i);
            boolean p2 = l2 >= start && checkPalindrome(s, l2, i);

            if (p1 || p2) {
                count += 1;
                start = i + 1;
            }
        }

        return count;
    }

}
