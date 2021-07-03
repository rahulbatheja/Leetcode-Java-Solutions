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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> output = new ArrayList<>();
        if (root == null)
            return output;

        TreeNode currentNode = root;
        Stack<TreeNode> auxStack = new Stack<>();
        auxStack.add(currentNode);
        output.add(currentNode.val);
        while (auxStack.isEmpty() && currentNode != null) {

            while (currentNode.left != null) {
                auxStack.add(currentNode.left);
                output.add(currentNode.val);
                currentNode = currentNode.left;
            }

            TreeNode poppedElement = auxStack.pop();
            while (poppedElement.right != null) {
                poppedElement = auxStack.pop();
            }

            currentNode = currentNode.right;
            auxStack.add(currentNode.right);
            output.add(currentNode.val);

        }


        return output;
    }
}