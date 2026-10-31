
class Solution {

    private static int MOD = 1000_000_007;
    private static int cache[][][];

    private static void recursiveSearch(int[][] grid, int x, int y, boolean movedRight) {

        int h = grid.length;
        int w = grid[0].length;

        // cache hit
        if (movedRight && cache[y][x][1] != -1) {
            return;
        }
        if (!movedRight && cache[y][x][0] != -1) {
            return;
        }

        // empty cell
        if (grid[y][x] == 0) {
            int answer = 0;

            // search right
            if (x != w - 1) {
                recursiveSearch(grid, x + 1, y, true);
                answer = (int) ((long) answer + (long) cache[y][x + 1][1]) % MOD;
            }

            // search down
            if (y != h - 1) {
                recursiveSearch(grid, x, y + 1, false);
                answer = (int) ((long) answer + (long) cache[y + 1][x][0]) % MOD;
            }

            cache[y][x][0] = answer;
            cache[y][x][1] = answer;
        }

        // mirror cell && moved right
        else if (movedRight) {
            if (y != h - 1) {
                recursiveSearch(grid, x, y + 1, false);
                cache[y][x][1] = cache[y + 1][x][0];
            } else {
                cache[y][x][1] = 0;
            }
        }

        // mirror cell && moved down
        else {
            if (x != w - 1) {
                recursiveSearch(grid, x + 1, y, true);
                cache[y][x][0] = cache[y][x + 1][1];
            } else {
                cache[y][x][0] = 0;
            }
        }

    }

    private static void recursiveSearch(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;
        int answer = 0;

        // search right
        if (w > 1) {
            recursiveSearch(grid, 1, 0, true);
            answer = (int) ((long) answer + (long) cache[0][1][1]) % MOD;
        }

        // search down
        if (h > 1) {
            recursiveSearch(grid, 0, 1, false);
            answer = (int) ((long) answer + (long) cache[1][0][0]) % MOD;
        }

        cache[0][0][1] = answer;
        cache[0][0][0] = answer;
    }

    public int uniquePaths(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;
        cache = new int[h][w][2];

        // initialize cache
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                cache[y][x][0] = -1;
                cache[y][x][1] = -1;
            }
        }
        cache[h - 1][w - 1][0] = 1;
        cache[h - 1][w - 1][1] = 1;

        recursiveSearch(grid);
        return cache[0][0][0];
    }

}
