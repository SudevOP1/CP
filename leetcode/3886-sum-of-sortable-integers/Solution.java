import java.util.ArrayList;
import java.util.List;

class Solution {

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        List<Integer> reverse = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    reverse.add(n / i);
                }
            }
        }

        divisors.addAll(reverse);
        if (n > 1) {
            divisors.add(n);
        }
        return divisors;
    }

    private boolean check(int[] nums, int blockLen) {

        int n = nums.length;
        int numBlocks = n / blockLen;
        int prevMax = Integer.MIN_VALUE;

        for (int blockNum = 0; blockNum < numBlocks; blockNum++) {

            boolean found = false;
            boolean ok = true;
            int min = nums[blockNum * blockLen];
            int max = nums[blockNum * blockLen];

            for (int comparison = 0; comparison < blockLen - 1; comparison++) {
                min = Math.min(min, nums[blockNum * blockLen + comparison + 1]);
                max = Math.max(max, nums[blockNum * blockLen + comparison + 1]);
                if (nums[blockNum * blockLen + comparison] > nums[blockNum * blockLen + comparison + 1]) {
                    if (found) {
                        ok = false;
                        break;
                    } else {
                        found = true;
                    }
                }
            }

            if (!ok) {
                return false;
            }

            if (found && nums[blockNum * blockLen + blockLen - 1] > nums[blockNum * blockLen]) {
                return false;
            }

            if (prevMax > min) {
                return false;
            }
            prevMax = max;
        }

        return true;
    }

    public int sortableIntegers(int[] nums) {

        int n = nums.length;
        int sum = 0;
        List<Integer> divisors = getDivisors(n);

        boolean alreadySorted = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                alreadySorted = false;
            }
        }
        if (alreadySorted) {
            sum += 1;
        }

        for (Integer i : divisors) {
            if (check(nums, i)) {
                sum += i;
            }
        }

        return sum;
    }

}
