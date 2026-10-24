
class Solution {

    private static final int[] months = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int a1 = months[Integer.valueOf(arriveAlice.substring(0, 2)) - 1]
                + Integer.valueOf(arriveAlice.substring(3, 5));
        int a2 = months[Integer.valueOf(leaveAlice.substring(0, 2)) - 1] + Integer.valueOf(leaveAlice.substring(3, 5));
        int b1 = months[Integer.valueOf(arriveBob.substring(0, 2)) - 1] + Integer.valueOf(arriveBob.substring(3, 5));
        int b2 = months[Integer.valueOf(leaveBob.substring(0, 2)) - 1] + Integer.valueOf(leaveBob.substring(3, 5));

        return Math.max(0, Math.min(a2, b2) - Math.max(a1, b1) + 1);
    }

}
