
class Solution {

    public int[] findColumnWidth(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int len = String.valueOf(grid[i][j]).length();

                if (ans[j] < len) {
                    ans[j] = len;
                }

            }
        }

        return ans;
    }

}
