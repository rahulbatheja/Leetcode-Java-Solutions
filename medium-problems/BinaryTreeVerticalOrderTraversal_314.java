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

    private class VerticalPair {
        int column;
        TreeNode node;

        VerticalPair() {
            this.column = 0;
            this.node = null;
        }

        VerticalPair(int column, TreeNode node) {
            this.column = column;
            this.node = node;
        }

    }


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;

        int min = 0;
        int max = 0;

        HashMap<Integer, ArrayList<Integer>> auxMap = new HashMap<>();
        Queue<VerticalPair> queue = new LinkedList<>();
        queue.offer(new VerticalPair(0, root));
        while (!queue.isEmpty()) {
            VerticalPair poppedVerticalPair = queue.poll();


            min = Math.min(min, poppedVerticalPair.column);
            max = Math.max(max, poppedVerticalPair.column);

            auxMap.putIfAbsent(poppedVerticalPair.column, new ArrayList<>());
            auxMap.get(poppedVerticalPair.column).add(poppedVerticalPair.node.val);
            if (poppedVerticalPair.node.left != null) {
                queue.add(new VerticalPair(poppedVerticalPair.column - 1, poppedVerticalPair.node.left));
            }

            if (poppedVerticalPair.node.right != null) {
                queue.add(new VerticalPair(poppedVerticalPair.column + 1, poppedVerticalPair.node.right));
            }


        }

        for (int i = min; i <= max; i++) {
            output.add(auxMap.get(i));
        }
        return output;

    }
}