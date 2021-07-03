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

    private int getSizeOfList(ListNode head) {
        if (head == null)
            return 0;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }


    public ListNode rotateRight(ListNode head, int noOfRotations) {

        if (head == null || noOfRotations == 0)
            return head;
        ListNode tempNode = head;
        int sizeOfList = getSizeOfList(tempNode);
        noOfRotations = noOfRotations % sizeOfList;
        if (noOfRotations == 0)
            return head;

        int noOfNextStepRequired = sizeOfList - noOfRotations - 1;
        while (noOfNextStepRequired > 0) {
            tempNode = tempNode.next;
            noOfNextStepRequired--;
        }

        ListNode newHead = tempNode.next;
        tempNode.next = null;

        ListNode newTempNode = newHead;
        while (newTempNode.next != null)
            newTempNode = newTempNode.next;
        newTempNode.next = head;
        return newHead;
    }
}