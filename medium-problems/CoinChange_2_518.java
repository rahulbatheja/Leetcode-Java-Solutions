


class Solution {
    public int change(int amount, int[] coins) {
        if (coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= amount; i++)
            dp[0][i] = 0;

        for (int coinIndex = 1; coinIndex <= coins.length; coinIndex++) {
            for (int amountIndex = 1; amountIndex <= amount; amountIndex++) {

                /**
                 * exclude current Number
                 */
                dp[coinIndex][amountIndex] = dp[coinIndex - 1][amountIndex];
                /**
                 * if and oonly if my current amount to make is greater than equal to current coin in hand
                 */
                if (amountIndex >= coins[coinIndex - 1])
                    dp[coinIndex][amountIndex] += dp[coinIndex][amountIndex - coins[coinIndex - 1]];
            }
        }

        return dp[coins.length][amount];
    }
}