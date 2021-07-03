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
            return root;

        TreeNode smallerValueNode;
        TreeNode largerValueNode;
        if (firstNode.val < secondNode.val) {
            smallerValueNode = firstNode;
            largerValueNode = secondNode;
        } else {
            smallerValueNode = secondNode;
            largerValueNode = firstNode;
        }

        return lowestCommonAncestorHelper(root, smallerValueNode, largerValueNode);

    }

    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode smallerValueNode, TreeNode largerValueNode) {

        if (root == null)
            return null;


        if ((root.val == smallerValueNode.val) || (root.val == largerValueNode.val))
            return root;

        if (smallerValueNode.val < root.val && largerValueNode.val > root.val)
            return root;


        if (smallerValueNode.val < root.val && largerValueNode.val < root.val)
            return lowestCommonAncestorHelper(root.left, smallerValueNode, largerValueNode);

        else
            return lowestCommonAncestorHelper(root.right, smallerValueNode, largerValueNode);


    }

}