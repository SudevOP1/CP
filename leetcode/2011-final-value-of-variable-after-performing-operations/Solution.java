
class Solution {

    public int finalValueAfterOperations(String[] operations) {

        int n = operations.length;
        int x = 0;

        for (int i = 0; i < n; i++) {
            if (operations[i].charAt(1) == '+') {
                x += 1;
            } else {
                x -= 1;
            }
        }

        return x;
    }

}
