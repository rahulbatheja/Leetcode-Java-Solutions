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
    /**
     *
     * the idea behind this solution is to keep distance of n nodes between fast pointer
     * and slow pointer
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 0 || head == null)
            return head;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        /**
         * move fast pointer n steps ahead
         */
        while (fastPointer != null && n > 0) {
            fastPointer = fastPointer.next;
            n--;
        }
        /**
         * if fast pointer becomes null provided n is valid in question
         * that means the element to be removed is head.
         */
        if (fastPointer == null)
            return slowPointer.next;

        /**
         * move fast and slow one by one till fast.next !=null
         */
        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        /**
         * remove slow pointer next
         */
        slowPointer.next = slowPointer.next.next;

        return head;
    }
}