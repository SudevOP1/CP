
class Solution {

    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();
        int count = 0;

        // count ones
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }

        // if there are less than k ones, return empty string
        if (count < k) {
            return "";
        }

        String answer = null;
        int left = 0;
        int ones = 0;
        for (int right = 0; right < n; right++) {

            // count ones in the current window
            if (s.charAt(right) == '1') {
                ones += 1;
            }

            // shrink the window from the left until we have at most k ones and the leftmost
            // character is not '0'
            while (ones > k || (left <= right && s.charAt(left) == '0')) {
                if (s.charAt(left) == '1') {
                    ones -= 1;
                }
                left += 1;
            }

            // check if we have exactly k ones in the current window
            if (ones == k) {
                String subString = s.substring(left, right + 1);
                if (answer == null || subString.length() < answer.length()
                        || (subString.length() == answer.length() && subString.compareTo(answer) < 0)) {
                    answer = subString;
                }
            }

        }

        return answer;
    }
}
