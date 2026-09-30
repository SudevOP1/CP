
class Solution {

    public int maxArea(int[] height) {

        int n = height.length;
        int l = 0;
        int r = n - 1;
        int best = 0;

        while (l < r) {

            best = Math.max(best, (r - l) * Math.min(height[l], height[r]));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return best;
    }

}
