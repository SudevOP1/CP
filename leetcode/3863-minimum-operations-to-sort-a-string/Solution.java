
class Solution {

    public int minOperations(String s) {

        int n = s.length();

        // case 0
        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            return 0;
        }

        // case -1
        if (n == 2) {
            return -1;
        }

        // case 1
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(minIndex)) {
                minIndex = i;
            }
            if (s.charAt(i) >= s.charAt(maxIndex)) {
                maxIndex = i;
            }
        }
        if (minIndex == 0 || maxIndex == n - 1) {
            return 1;
        }

        // case 3
        int numMin = 0;
        int numMax = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(minIndex)) {
                numMin += 1;
            }
            if (s.charAt(i) == s.charAt(maxIndex)) {
                numMax += 1;
            }
        }
        if (s.charAt(0) == s.charAt(maxIndex) && numMin == 1 && s.charAt(n - 1) == s.charAt(minIndex) && numMax == 1) {
            return 3;
        }

        // case 2
        return 2;
    }

}
