import java.util.List;

class Solution {

    public int maxSum(List<Integer> nums, int k) {

        int MOD = 1000000007;
        int[] count = new int[30];

        for (int x : nums) {
            for (int i = 0; i < 30; i++) {
                if ((x & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            long cur = 0;
            for (int j = 29; j >= 0; j--) {
                if (count[j] > 0) {
                    count[j]--;
                    cur |= (1 << j);
                }
            }
            res = (res + cur * cur) % MOD;
        }

        return (int) res;
    }

}
