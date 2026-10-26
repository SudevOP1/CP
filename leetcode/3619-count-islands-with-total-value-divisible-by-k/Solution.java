
class Solution {

    private static long getIslandValue(int[][] grid, int x, int y) {

        int h = grid.length;
        int w = grid[0].length;

        if (x == -1 || x == w || y == -1 || y == h || grid[y][x] == 0) {
            return 0;
        }

        long islandValue = grid[y][x];
        grid[y][x] = 0;

        islandValue += getIslandValue(grid, x - 1, y); // left
        islandValue += getIslandValue(grid, x, y - 1); // up
        islandValue += getIslandValue(grid, x + 1, y); // right
        islandValue += getIslandValue(grid, x, y + 1); // down

        return islandValue;
    }

    public int countIslands(int[][] grid, int k) {

        int h = grid.length;
        int w = grid[0].length;

        int count = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {

                long islandValue = getIslandValue(grid, x, y);

                if (islandValue != 0 && islandValue % k == 0) {
                    count += 1;
                }
            }
        }

        return count;
    }

}
