class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        robHelper(nums, 0, arr);
        return arr[0];
    }

    private int robHelper(int[] nums, int currentIndex, int[] auxSpace) {
        if (nums.length <= currentIndex)
            return 0;


        if (auxSpace[currentIndex] != -1)
            return auxSpace[currentIndex];

        int choice1 = robHelper(nums, currentIndex + 1, auxSpace);
        int choice2 = nums[currentIndex] + robHelper(nums, currentIndex + 2, auxSpace);
        auxSpace[currentIndex] = Math.max(choice2, choice1);
        return auxSpace[currentIndex];

    }


}