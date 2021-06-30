class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        if (nums.length == 0)
            return 0;

        int maxConsectiveForCompleteArray = 0;
        int maxConsectiveTillNow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                maxConsectiveTillNow++;
            } else {
                maxConsectiveForCompleteArray = Math.max(maxConsectiveForCompleteArray, maxConsectiveTillNow);
                maxConsectiveTillNow = 0;
            }
        }

        maxConsectiveForCompleteArray = Math.max(maxConsectiveForCompleteArray, maxConsectiveTillNow);
        return maxConsectiveForCompleteArray;

    }
}