class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        String rev = new StringBuilder(num).reverse().toString();
        return num.equals(rev);
    }
}
