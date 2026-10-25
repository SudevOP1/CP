
class Solution {

    private static boolean[][] visited;
    private static boolean[][] marked;

    private static boolean checkCell(int[][] grid, int x, int y, boolean up, boolean down, boolean left,
            boolean right) {

        if (grid[y][x] == 1) {
            return true;
        }

        if (visited[y][x]) {
            // already being explored in this search
            return true;
        }
        visited[y][x] = true;

        int h = grid.length;
        int w = grid[0].length;

        if ((up && (y == 0 || !checkCell(grid, x, y - 1, true, false, true, true)))
                || (down && (y == h - 1 || !checkCell(grid, x, y + 1, false, true, true, true)))
                || (left && (x == 0 || !checkCell(grid, x - 1, y, true, true, true, false)))
                || (right && (x == w - 1 || !checkCell(grid, x + 1, y, true, true, false, true)))) {
            return false;
        }

        return true;
    }

    private static boolean checkCell(int[][] grid, int x, int y) {
        return checkCell(grid, x, y, true, true, true, true);
    }

    private static void markVisited(int[][] grid, int x, int y, boolean up, boolean down, boolean left,
            boolean right) {

        if (grid[y][x] == 1 || marked[y][x]) {
            return;
        }

        marked[y][x] = true;
        int h = grid.length;
        int w = grid[0].length;

        if (up && y > 0) {
            markVisited(grid, x, y - 1, true, false, true, true);
        }
        if (down && y < h - 1) {
            markVisited(grid, x, y + 1, false, true, true, true);
        }
        if (left && x > 0) {
            markVisited(grid, x - 1, y, true, true, true, false);
        }
        if (right && x < w - 1) {
            markVisited(grid, x + 1, y, true, true, false, true);
        }
    }

    private static void markVisited(int[][] grid, int x, int y) {
        markVisited(grid, x, y, true, true, true, true);
    }

    public int closedIsland(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        if (w < 3 || h < 3) {
            return 0;
        }

        visited = new boolean[h][w];
        marked = new boolean[h][w];
        int count = 0;

        for (int y = 1; y < h - 1; y++) {
            for (int x = 1; x < w - 1; x++) {
                if (grid[y][x] == 1 || marked[y][x]) {
                    continue;
                }
                if (checkCell(grid, x, y)) {
                    count += 1;
                }
                markVisited(grid, x, y);
            }
        }

        return count;
    }

}
