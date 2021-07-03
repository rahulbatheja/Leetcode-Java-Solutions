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
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();


        while (root.left != null || root.right != null) {
            List<Integer> currentPath = new ArrayList<>();
            findLeavesHelper(root, null, false, currentPath);
            output.add(new ArrayList<>(currentPath));
        }

        output.add(new ArrayList<>(Collections.singletonList(root.val)));

        return output;

    }

    private void findLeavesHelper(TreeNode currentNode, TreeNode parent, boolean isLeftChild,
                                  List<Integer> currentLeafNodes) {
        if (currentNode == null)
            return;
        if (currentNode.left == null && currentNode.right == null) {
            currentLeafNodes.add(currentNode.val);
            if (parent != null) {
                if (isLeftChild)
                    parent.left = null;
                else
                    parent.right = null;
            }
            return;
        }
        findLeavesHelper(currentNode.left, currentNode, true, currentLeafNodes);
        findLeavesHelper(currentNode.right, currentNode, false, currentLeafNodes);

    }


}