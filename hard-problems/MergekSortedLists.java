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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        ListNode output = new ListNode(-1);
        ListNode result = output;

        PriorityQueue<ListNode> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        /**
         * inserting all starting points of lists if not null
         */
        for (ListNode list : lists) {
            if (list != null)
                priorityQueue.add(list);
        }

        while (!priorityQueue.isEmpty()) {
/**
 * polling out min value and inserting next pointer of polled out list
 */
            ListNode minValueNode = priorityQueue.poll();
            output.next = new ListNode(minValueNode.val);
            output = output.next;
            if (minValueNode.next != null)
                priorityQueue.add(minValueNode.next);

        }


        return result.next;
    }
}