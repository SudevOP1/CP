
class Solution {

    public int countServers(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;
        int count = 0;
        boolean[] rowsMarked = new boolean[h];

        for (int y = 0; y < h; y++) {
            int found = 0;
            for (int x = 0; x < w; x++) {
                found += grid[y][x];
            }
            if (found > 1) {
                count += found;
                rowsMarked[y] = true;
            }
        }

        for (int x = 0; x < w; x++) {
            int found = 0;
            int nonMarkedFound = 0;
            for (int y = 0; y < h; y++) {
                found += grid[y][x];
                if (!rowsMarked[y]) {
                    nonMarkedFound += grid[y][x];
                }
            }
            if (found > 1) {
                count += nonMarkedFound;
            }
        }

        return count;
    }

}
