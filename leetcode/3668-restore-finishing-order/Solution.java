
class Solution {

    public int[] recoverOrder(int[] order, int[] friends) {

        int n = order.length;
        int m = friends.length;
        int[] ans = new int[m];
        int ansIndex = 0;

        for (int i = 0; i < n; i++) {

            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (order[i] == friends[j]) {
                    found = true;
                    break;
                }
            }

            if (found) {
                ans[ansIndex++] = order[i];
            }
        }

        return ans;
    }

}
