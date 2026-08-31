
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

    public boolean isCriticalNode(int thisVal, int prevVal, int nextVal) {

        // local maxima
        if (thisVal > prevVal && thisVal > nextVal) {
            return true;
        }

        // local minima
        if (thisVal < prevVal && thisVal < nextVal) {
            return true;
        }

        return false;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int minD = -1;
        int maxD = -1;

        ListNode current = head.next;
        int prevVal = head.val;
        int firstCriticalNodeIndex = -1;
        int currentNodeIndex = 1;
        int lastCriticalNodeIndex = -1;

        while (current.next != null) {
            if (isCriticalNode(current.val, prevVal, current.next.val)) {

                // first critical node
                if (firstCriticalNodeIndex == -1) {
                    firstCriticalNodeIndex = currentNodeIndex;

                    // continue to next node
                    lastCriticalNodeIndex = currentNodeIndex;
                    prevVal = current.val;
                    current = current.next;
                    currentNodeIndex += 1;
                    continue;
                }

                // second critical node
                if (minD == -1) {
                    minD = currentNodeIndex - lastCriticalNodeIndex;

                    // continue to next node
                    lastCriticalNodeIndex = currentNodeIndex;
                    prevVal = current.val;
                    current = current.next;
                    currentNodeIndex += 1;
                    continue;
                }

                // remaining critical nodes
                if (currentNodeIndex - lastCriticalNodeIndex < minD) {
                    minD = currentNodeIndex - lastCriticalNodeIndex;
                }

                lastCriticalNodeIndex = currentNodeIndex;
            }

            prevVal = current.val;
            current = current.next;
            currentNodeIndex += 1;
        }

        if (lastCriticalNodeIndex != firstCriticalNodeIndex) {
            maxD = lastCriticalNodeIndex - firstCriticalNodeIndex;
        }

        return new int[] { minD, maxD };
    }
}
