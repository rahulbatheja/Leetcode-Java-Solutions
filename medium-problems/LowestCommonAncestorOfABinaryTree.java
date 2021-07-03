/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode firstNode, TreeNode secondNode) {

        if (root == null)
            return null;
        if (root == firstNode || root == secondNode)
            return root;

        TreeNode leftSide = lowestCommonAncestor(root.left, firstNode, secondNode);
        TreeNode rightSide = lowestCommonAncestor(root.right, firstNode, secondNode);

        if (leftSide == null && rightSide == null)
            return null;
        else if (leftSide != null && rightSide != null)
            return root;
        else
            return leftSide != null ? leftSide : rightSide;

    }
}