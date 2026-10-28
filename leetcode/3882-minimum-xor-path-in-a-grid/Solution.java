
class Solution {

    private static final int MAX = 1024;

    public int minCost(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        boolean[][][] reachable = new boolean[h][w][MAX];
        reachable[0][0][grid[0][0]] = true;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {

                int value = grid[y][x];

                for (int v = 0; v < MAX; v++) {
                    if ((y > 0 && reachable[y - 1][x][v]) || (x > 0 && reachable[y][x - 1][v])) {
                        reachable[y][x][v ^ value] = true;
                    }
                }
            }
        }

        for (int v = 0; v < MAX; v++) {
            if (reachable[h - 1][w - 1][v]) {
                return v;
            }
        }

        return -1;
    }

}
