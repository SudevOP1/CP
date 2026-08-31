class Solution {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[128];

            for (int j = i; j < n; j++) {
                if (seen[s.charAt(j)]) {
                    break;
                }
                seen[s.charAt(j)] = true;

                if (maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                }
            }
        }

        return maxLen;
    }
}
