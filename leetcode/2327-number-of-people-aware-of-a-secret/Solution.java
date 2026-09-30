
class Solution {

    public int peopleAwareOfSecret(int n, int delay, int forget) {

        final int MOD = 1_000_000_007;

        long[] peopleWhoGotToKnowToday = new long[n];
        peopleWhoGotToKnowToday[0] = 1;

        for (int day = 1; day < n; day++) {
            long numPeopleToAdd = 0;
            for (int i = Math.max(0, day - forget + 1); i <= day - delay; i++) {
                numPeopleToAdd = (numPeopleToAdd + peopleWhoGotToKnowToday[i]) % MOD;
            }
            peopleWhoGotToKnowToday[day] = numPeopleToAdd;
        }

        long count = 0;
        for (int i = Math.max(0, n - forget); i < n; i++) {
            count = (count + peopleWhoGotToKnowToday[i]) % MOD;
        }

        return (int) count;
    }

}
