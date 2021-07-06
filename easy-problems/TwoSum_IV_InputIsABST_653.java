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
    public boolean findTarget(TreeNode root, int target) {

        if (root == null)
            return false;

        List<Integer> sortedList = new ArrayList<>();
        getInorder(sortedList, root);

        return find(target, sortedList);

    }

    private void getInorder(List<Integer> list, TreeNode root) {


        if (root == null)
            return;

        getInorder(list, root.left);
        list.add(root.val);
        getInorder(list, root.right);
    }


    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value, List<Integer> list) {

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) == value)
                return true;

            if (list.get(left) + list.get(right) < value)
                left++;
            else right--;


        }
        return false;

    }


}

