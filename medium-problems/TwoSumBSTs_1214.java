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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        if (root1 == null || root2 == null)
            return false;

        HashSet<Integer> hashSet = new HashSet<Integer>();
        getInOrderTraversal(hashSet, root1);

        return checkTwoSum(hashSet, root2, target);

    }

    private boolean checkTwoSum(HashSet<Integer> hashSet, TreeNode root, int target) {
        if (root == null)
            return false;

        if (hashSet.contains(target - root.val))
            return true;
        else {
            boolean fromLeft = checkTwoSum(hashSet, root.left, target);
            if (fromLeft)
                return true;

            return checkTwoSum(hashSet, root.right, target);

        }


    }


    private void getInOrderTraversal(HashSet<Integer> hashSet, TreeNode root) {
        if (root == nullv)
            return;
        getInOrderTraversal(hashSet, root.left);
        hashSet.add(root.val);
        getInOrderTraversal(hashSet, root.right);
    }

}