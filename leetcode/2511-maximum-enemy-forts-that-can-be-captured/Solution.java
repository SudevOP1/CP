
class Solution {

    public int captureForts(int[] forts) {

        int n = forts.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                int j;
                int l = 0;
                int r = 0;

                for (j = i - 1; j >= 0 && forts[j] == 0; j--) {
                }
                if (j >= 0 && forts[j] == -1) {
                    l = i - j - 1;
                }

                for (j = i + 1; j < n && forts[j] == 0; j++) {
                }
                if (j < n && forts[j] == -1) {
                    l = j - i - 1;
                }

                max = Math.max(max, Math.max(l, r));
                // System.out.println("i: " + i + ", l: " + l + ", r: " + r + ", max: " + max);
            }
        }

        return max;
    }

}
