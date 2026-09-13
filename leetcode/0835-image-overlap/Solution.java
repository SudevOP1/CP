import java.util.ArrayList;
import java.util.List;

class Solution {

    int[][] globalImg1;
    int[][] globalImg2;
    List<int[]> img1Positions;
    List<int[]> img2Positions;

    private int countOverlap(int dx, int dy) {

        int numOverlaps = 0;
        int n = globalImg2.length;
        int img1PositionsSize = img1Positions.size();

        for (int i = 0; i < img1PositionsSize; i++) {

            int img2X = img1Positions.get(i)[0] + dx;
            int img2Y = img1Positions.get(i)[1] + dy;

            // translated to outside the border
            if (img2X < 0 || img2X >= n || img2Y < 0 || img2Y >= n) {
                continue;
            }

            if (globalImg2[img2X][img2Y] == 1) {
                numOverlaps += 1;
            }
        }

        return numOverlaps;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        if (n == 1) {
            if (img1[0][0] == 0 || img2[0][0] == 0) {
                return 0;
            }
            return 1;
        }

        // set img1Positions & img2Positions
        img1Positions = new ArrayList<>();
        img2Positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    img1Positions.add(new int[] { i, j });
                }
                if (img2[i][j] == 1) {
                    img2Positions.add(new int[] { i, j });
                }
            }
        }

        if (img1Positions.size() == 0 || img2Positions.size() == 0) {
            return 0;
        }

        // copy img1 & img2 to globalImg1 & globalImg2
        globalImg1 = new int[n][n];
        globalImg2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                globalImg1[i][j] = img1[i][j];
                globalImg2[i][j] = img2[i][j];
            }
        }

        // check overlap of first '1' in img1 with every '1' in img2
        int maxOverlap = 0;
        for (int i = -n + 1; i < n; i++) {
            for (int j = -n + 1; j < n; j++) {
                int numOverlap = countOverlap(i, j);
                if (maxOverlap < numOverlap) {
                    maxOverlap = numOverlap;
                }
            }
        }

        return maxOverlap;
    }

}
