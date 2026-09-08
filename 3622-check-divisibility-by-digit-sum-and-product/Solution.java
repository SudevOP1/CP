
class Solution {

    public boolean checkDivisibility(int n) {

        int sum = 0;
        int pdt = 1;
        int ogN = n;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            pdt *= digit;
            n /= 10;
        }

        return ogN % (sum + pdt) == 0;
    }

}
