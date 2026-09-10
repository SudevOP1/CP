import java.lang.Math;

class Solution {

    private static double d(int x1, int x2, int y1, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double d1 = d(x1, xCenter, y1, yCenter);
        double d2 = d(x1, xCenter, y2, yCenter);
        double d3 = d(x2, xCenter, y1, yCenter);
        double d4 = d(x2, xCenter, y2, yCenter);

        return ((x1 - radius <= xCenter && xCenter <= x2 + radius && y1 <= yCenter && yCenter <= y2)
                || (y1 - radius <= yCenter && yCenter <= y2 + radius && x1 <= xCenter && xCenter <= x2)
                || d1 <= radius || d2 <= radius || d3 <= radius || d4 <= radius);
    }

}
