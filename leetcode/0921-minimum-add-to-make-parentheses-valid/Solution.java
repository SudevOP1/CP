
class Solution {

    public int minAddToMakeValid(String s) {

        int n = s.length();
        int ans = 0;
        int open = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }
        }

        ans += open;
        return ans;
    }

}
