/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        return swapPairsHelper(head);

    }

    private ListNode swapPairsHelper(ListNode head) {


        if (head == null || head.next == null)
            return head;

        /**
         * Assume that recusive function will bring answer to subProblem anyhow
         */
        ListNode subProblemAns = swapPairsHelper(head.next.next);

        /**
         * just swap from two nodes and boom you are done
         */
        ListNode current = head;
        ListNode next = head.next;
        current.next = subProblemAns;
        next.next = current;
        return next;


    }


}