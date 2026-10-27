
class Solution {

    public String[] createGrid(int m, int n) {

        String[] grid = new String[m];

        for (int y = 0; y < m; y++) {
            StringBuilder sb = new StringBuilder();

            for (int x = 0; x < n; x++) {
                if (y == 0 || x == n - 1) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }

            grid[y] = sb.toString();
        }

        return grid;
    }

}
