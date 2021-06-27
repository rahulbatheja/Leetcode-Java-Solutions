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

    private static class ListNodePair {
        ListNode head;
        ListNode tail;


        ListNodePair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }

    }


    private ListNodePair reverseList(ListNode head, ListNode tail) {
        if (head == null)
            return null;

        ListNode prev = null;
        ListNode current = head;
        ListNode tailToBe = head;
        ListNode next = head.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null)
                next = next.next;
        }

        return new ListNodePair(prev, tailToBe);
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null)
            return head;

        ListNode headToAssignLater = head;
        while (headToAssignLater != null && headToAssignLater.next != null && headToAssignLater.next.val != left)
            headToAssignLater = headToAssignLater.next;

        if (headToAssignLater == null)
            return head;

        ListNode toReverseListHead = headToAssignLater.next;

        ListNode toReverseListTail = toReverseListHead;
        while (toReverseListTail != null && toReverseListTail.val != right)
            toReverseListTail = toReverseListTail.next;

        if (toReverseListTail == null)
            return head;

        ListNode tailToAssignLater = toReverseListTail.next;
        toReverseListTail.next = null;


        ListNodePair reversedList = reverseList(toReverseListHead, toReverseListTail);
        headToAssignLater.next = reversedList.head;
        reversedList.tail.next = tailToAssignLater;

        return head;
    }
}