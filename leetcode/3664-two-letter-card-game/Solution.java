
class Solution {

    private static int pairs(int s, int m) {
        return Math.min(s / 2, s - m);
    }

    public int score(String[] cards, char x) {

        int[] a = new int[26];
        int[] b = new int[26];
        int both = 0;

        for (String c : cards) {
            char c0 = c.charAt(0), c1 = c.charAt(1);

            if (c0 == x && c1 == x) {
                both++;
            }

            else if (c0 == x) {
                a[c1 - 'a']++;
            }

            else if (c1 == x) {
                b[c0 - 'a']++;
            }
        }

        int sumA = 0;
        int maxA = 0;
        int sumB = 0;
        int maxB = 0;
        int best = 0;

        for (int i = 0; i < 26; i++) {
            sumA += a[i];
            maxA = Math.max(maxA, a[i]);
            sumB += b[i];
            maxB = Math.max(maxB, b[i]);
        }

        for (int k = 0; k <= both; k++) {
            best = Math.max(best,
                    pairs(sumA + k, Math.max(maxA, k)) + pairs(sumB + both - k, Math.max(maxB, both - k)));
        }

        return best;
    }

}
