import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> list = new ArrayList<>();

    private void generateParanthesis(int open, int close, StringBuilder sb) {

        if (open == 0 && close == 0) {
            list.add(sb.toString());
            return;
        }

        if (open > 0) {
            sb.append('(');
            generateParanthesis(open - 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close > open) {
            sb.append(')');
            generateParanthesis(open, close - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        generateParanthesis(n, n, new StringBuilder());
        return list;
    }

}
