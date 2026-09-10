
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1First = l1;
        int carry = 0;
        int sum = 0;
        int newVal = 0;

        while (true) {

            sum = l1.val + l2.val;
            newVal = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            l1.val = newVal;

            if (l1.next == null && l2.next == null) {
                if (carry != 0) {
                    l1.next = new ListNode(carry);
                }
                break;
            }

            if (l1.next == null) {
                l1.next = addTwoNumbers(l2.next, new ListNode(carry));
                break;
            }

            if (l2.next == null) {
                l2.next = addTwoNumbers(l1.next, new ListNode(carry));
                break;
            }

            l1 = l1.next;
            l2 = l2.next;

        }

        return l1First;
    }
}
