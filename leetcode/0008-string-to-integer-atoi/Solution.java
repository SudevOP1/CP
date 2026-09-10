
class Solution {

    public int myAtoi(String s) {

        boolean negative = false;
        int firstDigitIndex = -1;

        // find firstDigitIndex
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+') {
                firstDigitIndex = i + 1;
                break;
            }

            if (c == '-') {
                negative = true;
                firstDigitIndex = i + 1;
                break;
            }

            if ("1234567890".contains(String.valueOf(c))) {
                firstDigitIndex = i;
                break;
            }

            if (c != ' ') {
                return 0;
            }
        }

        if (firstDigitIndex == -1) {
            return 0;
        }

        // get digits
        StringBuilder sb = new StringBuilder();
        for (int i = firstDigitIndex; i < s.length(); i++) {
            char c = s.charAt(i);

            if ("1234567890".contains(String.valueOf(c))) {
                sb.append(c);
            } else {
                break;
            }
        }

        if (sb.length() == 0) {
            return 0;
        }

        // String -> long
        long l = 0;
        for (int i = 0; i < sb.length(); i++) {
            l = l * 10 + (sb.charAt(i) - '0');
            if (l > 2147483648L) {
                l = 2147483648L;
                break;
            }
        }
        l *= negative ? -1 : 1;

        // check bounds
        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) l;
    }

}
