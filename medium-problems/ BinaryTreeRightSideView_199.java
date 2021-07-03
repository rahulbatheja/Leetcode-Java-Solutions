/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null)
            return output;


        LinkedList<TreeNode> auxQueue = new LinkedList<>();
        auxQueue.addFirst(root);
        output.add(root.val);
        while (!auxQueue.isEmpty()) {
            int currentQueueSize = auxQueue.size();
            TreeNode frontElement = auxQueue.removeFirst();
            while (currentQueueSize > 0) {
                if (frontElement.left != null)
                    auxQueue.addLast(frontElement.left);
                if (frontElement.right != null)
                    auxQueue.addLast(frontElement.right);
                currentQueueSize--;

            }
            if (!auxQueue.isEmpty())
                output.add(auxQueue.getLast().val);

        }

        return output;
    }
}