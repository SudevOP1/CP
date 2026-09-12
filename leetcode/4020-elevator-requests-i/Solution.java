
class Solution {

    public int elevatorRequests(int n, int[] requests) {

        int total = 0;
        int curr = 0;

        for (int i = 0; i < requests.length; i++) {
            int diff = Math.abs(curr - requests[i]);
            total += diff;
            curr = requests[i];
        }

        return total;
    }

}
