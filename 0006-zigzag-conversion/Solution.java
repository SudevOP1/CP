import java.util.ArrayList;
import java.util.List;

class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<List<Character>> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        int direction = 1;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            rows.get(depth).add(s.charAt(i));
            depth += direction;
            if (depth == numRows || depth == -1) {
                direction *= -1;
                depth += direction * 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> row : rows) {
            for (char c : row) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
