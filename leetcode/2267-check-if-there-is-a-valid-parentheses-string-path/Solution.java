import java.util.Stack;

class Solution {

    private char[][] grid;
    boolean[][][] cache;

    private String concat(String s, char c) {
        StringBuilder sb = new StringBuilder(s);
        sb.append(c);
        return sb.toString();
    }

    private boolean checkValidString(String s) {

        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push('(');
            }

            if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }

    private boolean checkGrid(String cur, int i, int j, int balance) {

        balance += this.grid[i][j] == '(' ? 1 : -1;

        // more ')' than '(' in cur
        if (balance < 0) {
            return false;
        }

        // cache hit
        if (cache[i][j][balance]) {
            return false;
        }

        // cache miss
        cache[i][j][balance] = true;
        cur = concat(cur, this.grid[i][j]);
        int m = this.grid.length;
        int n = this.grid[0].length;

        // bottom right reached
        if (i == m - 1 && j == n - 1) {
            boolean answer = checkValidString(cur);
            if (answer) {
                return true;
            }
            return false;
        }

        // check down
        boolean check1 = false;
        if (i != m - 1) {
            check1 = checkGrid(cur, i + 1, j, balance);
        }

        // check right
        boolean check2 = false;
        if (!check1 && j != n - 1) {
            check2 = checkGrid(cur, i, j + 1, balance);
        }

        return check1 || check2;
    }

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // odd path length
        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        this.grid = new char[m][n];
        this.cache = new boolean[m][n][m + n];

        // copy grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }

        return checkGrid("", 0, 0, 0);
    }

}
