
class Solution {

    public int lengthOfLastWord(String s) {

        int n = s.length();
        int count = 0;
        int i = n - 1;

        // skip spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i -= 1;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            i -= 1;
            count += 1;
        }

        return count;
    }

}
