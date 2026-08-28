class Solution {

    private String buildPalindrome(String firstHalf, char mid, int n) {
        StringBuilder sb = new StringBuilder(firstHalf);
        if (n % 2 != 0) {
            sb.append(mid);
        }
        sb.append(new StringBuilder(firstHalf).reverse());
        return sb.toString();
    }

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a'] += 1;
        }

        char mid = 0;
        int oddCount = 0;
        for (int c = 0; c < 26; c++) {
            if (counts[c] % 2 != 0) {
                oddCount += 1;
                mid = (char) ('a' + c);
            }
        }
        if (oddCount > 1 || (oddCount == 1 && n % 2 == 0)) {
            return "";
        }

        int h = n / 2;
        int[] half = new int[26];
        for (int c = 0; c < 26; c++) {
            half[c] = counts[c] / 2;
        }

        int[] avail = half.clone();
        char[] bump = new char[h];
        int matched = 0;
        while (matched < h) {
            int t = target.charAt(matched) - 'a';
            for (int c = t + 1; c < 26; c++) {
                if (avail[c] > 0) {
                    bump[matched] = (char) ('a' + c);
                    break;
                }
            }
            if (avail[t] == 0) {
                break;
            }
            avail[t] -= 1;
            matched += 1;
        }

        if (matched == h) {
            String possible = buildPalindrome(target.substring(0, h), mid, n);
            if (possible.compareTo(target) > 0) {
                return possible;
            }
        }

        for (int i = Math.min(matched, h - 1); i >= 0; i--) {
            if (bump[i] == 0) {
                continue;
            }

            int[] rest = half.clone();
            for (int j = 0; j < i; j++) {
                rest[target.charAt(j) - 'a'] -= 1;
            }
            rest[bump[i] - 'a'] -= 1;

            StringBuilder firstHalf = new StringBuilder(target.substring(0, i));
            firstHalf.append(bump[i]);
            for (int c = 0; c < 26; c++) {
                for (int k = 0; k < rest[c]; k++) {
                    firstHalf.append((char) ('a' + c));
                }
            }
            return buildPalindrome(firstHalf.toString(), mid, n);
        }

        return "";
    }

}
