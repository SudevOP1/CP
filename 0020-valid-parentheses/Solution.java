import java.util.Stack;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char p = stack.pop();

            if (c == ')' && p != '(') {
                return false;
            }
            if (c == '}' && p != '{') {
                return false;
            }
            if (c == ']' && p != '[') {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
