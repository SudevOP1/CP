
class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();
        int prefixLength = 0;
        while (prefixLength < n && count[target.charAt(prefixLength) - 'a'] > 0) {
            count[target.charAt(prefixLength) - 'a']--;
            prefix.append(target.charAt(prefixLength));
            prefixLength++;
        }

        for (int p = prefixLength; p >= 0; p--) {

            if (p < n) {
                for (int c = target.charAt(p) - 'a' + 1; c < 26; c++) {
                    if (count[c] == 0) {
                        continue;
                    }

                    StringBuilder answer = new StringBuilder(prefix.substring(0, p));
                    answer.append((char) ('a' + c));
                    count[c]--;

                    for (int d = 0; d < 26; d++) {
                        for (int k = 0; k < count[d]; k++) {
                            answer.append((char) ('a' + d));
                        }
                    }
                    return answer.toString();
                }
            }

            if (p > 0) {
                count[target.charAt(p - 1) - 'a']++;
            }
        }

        return "";
    }
}
