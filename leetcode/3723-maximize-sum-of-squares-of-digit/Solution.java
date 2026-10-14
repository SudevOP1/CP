
class Solution {

    public String maxSumOfSquares(int num, int sum) {

        if (sum > 9 * num) {
            return "";
        }

        int sumLeft = sum;
        int[] digits = new int[num];

        for (int i = 0; i < num; i++) {

            if (sumLeft == 0) {
                digits[i] = 0;
            }

            else if (sumLeft < 10) {
                digits[i] = sumLeft;
                sumLeft = 0;
            }

            else {
                digits[i] = 9;
                sumLeft -= 9;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }

}
