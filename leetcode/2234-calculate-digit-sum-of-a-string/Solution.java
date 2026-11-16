
class Solution {

    public String digitSum(String s, int k) {

        int n = s.length();

        while (n > k) {
            StringBuilder newS = new StringBuilder();

            for (int i = 0; i < n; i += k) {
                newS.append(s.substring(i, Math.min(i + k, n)).chars().map(d -> d - '0').sum());
            }

            s = newS.toString();
            n = s.length();
        }

        return s;
    }

}
