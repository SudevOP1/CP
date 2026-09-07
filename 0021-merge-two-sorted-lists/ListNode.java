
// public class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode curr;

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            head.val = list1.val;
            list1 = list1.next;
        } else {
            head.val = list2.val;
            list2 = list2.next;
        }
        curr = head;

        while (true) {
            if (list1 == null) {
                curr.next = list2;
                break;
            }
            if (list2 == null) {
                curr.next = list1;
                break;
            }
            curr.next = new ListNode();
            curr = curr.next;
            if (list1.val < list2.val) {
                curr.val = list1.val;
                list1 = list1.next;
            } else {
                curr.val = list2.val;
                list2 = list2.next;
            }
        }

        return head;

    }

}
