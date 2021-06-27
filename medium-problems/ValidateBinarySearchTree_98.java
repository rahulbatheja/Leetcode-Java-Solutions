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
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    private boolean isValidBSTHelper(TreeNode root, long minValue, long maxValue) {

        if (root == null)
            return true;

        if ((root.val > minValue) || (root.val < maxValue))
            return false;

        return isValidBSTHelper(root.left, minValue, root.val) &&
                isValidBSTHelper(root.right, root.val, maxValue);
    }


}