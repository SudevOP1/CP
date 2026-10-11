
class Solution {

    private static int gcd(int a, int b) {

        int min = Math.min(a, b);

        if (a % min == 0 && b % min == 0) {
            return min;
        }

        for (int i = min / 2; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        return 1;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode temp = head;
        while (temp.next != null) {
            ListNode newNode = new ListNode(gcd(temp.val, temp.next.val), temp.next);
            temp.next = newNode;
            temp = temp.next.next;
        }

        return head;
    }

}
