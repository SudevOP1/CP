
class Solution {

    private int checkMaxDepth(String s) {

        int n = s.length();
        int maxDepth = 0;
        int curDepth = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // '('
            if (c == '(') {
                curDepth += 1;
                if (maxDepth < curDepth) {
                    maxDepth = curDepth;
                }
            }

            // ')'
            if (c == ')') {
                curDepth -= 1;
            }

            // '+', '-', '*', '/'
            else {
                continue;
            }
        }

        return maxDepth;
    }

    public int maxDepth(String s) {
        return checkMaxDepth(s);
    }

}
