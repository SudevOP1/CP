class Solution {

    public String longestCommonPrefix(String[] strs) {

        String str = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int len = Math.min(str.length(), strs[i].length());

            int j = 0;
            while (j < len && str.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            str = str.substring(0, j);

            if (str.isEmpty()) {
                return "";
            }
        }

        return str;
    }
}
