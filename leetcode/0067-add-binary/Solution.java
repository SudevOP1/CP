
class Solution {

    private static char[] add(char a, char b, char c) {

        int num1 = 0;
        if (a == '1') {
            num1 += 1;
        }
        if (b == '1') {
            num1 += 1;
        }
        if (c == '1') {
            num1 += 1;
        }

        System.out.println(a + " + " + b + " + " + c + " = " + (num1 >= 2 ? '1' : '0') + (num1 % 2 == 0 ? '0' : '1'));
        return new char[] { num1 >= 2 ? '1' : '0', num1 % 2 == 0 ? '0' : '1' };
    }

    private static char[] add(char a, char b) {
        if (a == '1' && b == '1') {
            System.out.println(a + " + " + b + " = " + '1' + '0');
            return new char[] { '1', '0' };
        }
        if (a == '1' || b == '1') {
            System.out.println(a + " + " + b + " = " + '0' + '1');
            return new char[] { '0', '1' };
        }
        System.out.println(a + " + " + b + " = " + '0' + '0');
        return new char[] { '0', '0' };
    }

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int an = a.length();
        int bn = b.length();
        char carry = '0';

        int i;
        for (i = 0; i < Math.min(an, bn); i++) {
            char[] ans = add(a.charAt(an - 1 - i), b.charAt(bn - 1 - i), carry);
            carry = ans[0];
            sb.append(ans[1]);
        }

        if (an < bn) {
            for (; i < bn; i++) {
                char[] ans = add(b.charAt(bn - 1 - i), carry);
                carry = ans[0];
                sb.append(ans[1]);
            }
        }

        if (an > bn) {
            for (; i < an; i++) {
                char[] ans = add(a.charAt(an - 1 - i), carry);
                carry = ans[0];
                sb.append(ans[1]);
            }
        }

        if (carry == '1') {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

}
