class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;

        int[][] dp = new int[grid.length][grid[0].length];

        for (int row = dp.length - 1; row >= 0; row--) {
            for (int col = dp[0].length - 1; col >= 0; col--) {
                /**
                 * assign right most dp cell as same cost of grid
                 */
                if (row == dp.length - 1 && col == dp[0].length - 1) {
                    dp[row][col] = grid[row][col];
                } else if (row == dp.length - 1) {
                    /**
                     * last row, we can't move downwards
                     */
                    dp[row][col] = grid[row][col] + dp[row][col + 1];
                } else if (col == dp[0].length - 1) {
                    /**
                     * last col, we can't move right
                     */
                    dp[row][col] = grid[row][col] + dp[row + 1][col];
                } else {
                    /**
                     * min of right and down cell
                     */
                    dp[row][col] = grid[row][col] + Math.min(
                            dp[row + 1][col], dp[row][col + 1]
                    );


                }
            }

        }

        return dp[0][0];
    }
}