
class Solution {

    private int i;

    private String helper(String s) {

        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (c == '(') {
                sb.append(new StringBuilder(helper(s)).reverse());
            }

            else if (c == ')') {
                break;
            }

            else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String reverseParentheses(String s) {
        i = 0;
        return helper(s);
    }

}
