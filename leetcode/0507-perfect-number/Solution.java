import java.util.List;
import java.util.ArrayList;

class Solution {

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        List<Integer> reverse = new ArrayList<>();

        divisors.add(1);
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    reverse.add(n / i);
                }
            }
        }

        divisors.addAll(reverse);
        return divisors;
    }

    public boolean checkPerfectNumber(int num) {

        if (num == 1) {
            return false;
        }

        List<Integer> divisors = getDivisors(num);
        int sum = 0;

        for (Integer i : divisors) {
            sum += i;
        }

        if (sum == num) {
            return true;
        }
        return false;
    }

}
