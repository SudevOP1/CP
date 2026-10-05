
class Solution {

    private static int[] getScore(String s, int start) {

        int n = s.length();
        int score = 0;
        int i;

        for (i = start + 1; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(' && s.charAt(i + 1) == ')') {
                score += 1;
                i += 1;
            }

            else if (c == '(') {
                int[] innerScore = getScore(s, i);
                score += 2 * innerScore[0];
                i = innerScore[1];
            }

            else if (c == ')') {
                break;
            }
        }

        return new int[] { score, i };
    }

    private static int[] getScore(String s) {
        return getScore(s, -1);
    }

    public int scoreOfParentheses(String s) {
        return getScore(s)[0];
    }

}
