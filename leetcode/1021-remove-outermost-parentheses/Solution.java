import java.util.List;
import java.util.ArrayList;

class Solution {

    public String removeOuterParentheses(String s) {

        List<String> primitiveDecomp = new ArrayList<>();
        int n = s.length();

        int depth = 0;
        int begin = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                depth += 1;
            } else {
                depth -= 1;
            }

            if (depth == 0) {
                primitiveDecomp.add(s.substring(begin, i + 1));
                begin = i + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String primitiveS : primitiveDecomp) {
            sb.append(primitiveS.substring(1, primitiveS.length() - 1));
        }

        return sb.toString();
    }

}
