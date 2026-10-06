
class Solution {

    public int minDistance(String word1, String word2) {

        int n = word1.length() + 1;
        int m = word2.length() + 1;

        int[][] table = new int[m][n];

        for (int i = 0; i < m; i++) {
            table[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            table[0][j] = j;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                int contestant1 = table[i - 1][j] + 1;
                int contestant2 = table[i][j - 1] + 1;
                int contestant3 = table[i - 1][j - 1] + (word1.charAt(j - 1) == word2.charAt(i - 1) ? 0 : 1);

                table[i][j] = Math.min(Math.min(contestant1, contestant2), contestant3);
            }
        }

        return table[m - 1][n - 1];
    }

}
