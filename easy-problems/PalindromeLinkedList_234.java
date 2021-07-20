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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode newHead = new ListNode(-1);
        ListNode originalTempHead = head;

        ListNode newList = newHead;
        while (originalTempHead != null) {
            newList.next = new ListNode(originalTempHead.val);
            newList = newList.next;
            originalTempHead = originalTempHead.next;

        }
        return isPalindrome(head, newHead.next);
    }

    private boolean isPalindrome(ListNode head1, ListNode head2) {

        if (head1 == null && head2 == null)
            return true;
        if (head1 == null || head2 == null)
            return false;
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }


}