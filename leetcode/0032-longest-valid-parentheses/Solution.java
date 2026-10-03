import java.util.Stack;

class Solution {

    public int longestValidParentheses(String s) {

        int n = s.length();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            }
            if (c == ')') {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (max < i - stack.peek()) {
                max = i - stack.peek();
            }
        }

        return max;
    }

}
