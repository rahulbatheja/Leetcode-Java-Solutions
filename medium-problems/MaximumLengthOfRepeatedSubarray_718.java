class Solution {
    public int findLength(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0)
            return 0;

        int max = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int num1 = nums1[i - 1];
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);

            }
        }

        return max;
    }
}