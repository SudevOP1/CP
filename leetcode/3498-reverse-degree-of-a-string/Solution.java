
class Solution {

    public int reverseDegree(String s) {

        int n = s.length();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer += (i + 1) * ('z' - s.charAt(i) + 1);
        }

        return answer;
    }

}
