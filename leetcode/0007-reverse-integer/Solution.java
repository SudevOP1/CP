
class Solution {

    public int reverse(int x) {

        String s = String.valueOf(x);
        boolean negative = x < 0;
        if (negative) {
            s = s.substring(1);
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        long l = Long.parseLong(sb.toString());
        l *= negative ? -1 : 1;

        if (l < Integer.MIN_VALUE || Integer.MAX_VALUE < l) {
            return 0;
        }

        return (int) l;
    }

}
