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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null)
            return output;


        Queue<TreeNode> auxQueue = new LinkedList<>();
        auxQueue.add(root);
        output.add(root.val);
        while (!auxQueue.isEmpty()) {
            int currentQueueSize = auxQueue.size();
            int levelMax = Integer.MIN_VALUE;
            while (currentQueueSize > 0) {
                TreeNode frontElement = auxQueue.poll();
                if (frontElement.left != null) {
                    levelMax = Math.max(levelMax, frontElement.left.val);
                    auxQueue.add(frontElement.left);
                }
                if (frontElement.right != null) {
                    levelMax = Math.max(levelMax, frontElement.right.val);
                    auxQueue.add(frontElement.right);
                }

                currentQueueSize--;
            }
            output.add(levelMax);
        }


        return output.subList(0, output.size() - 1);
    }
}