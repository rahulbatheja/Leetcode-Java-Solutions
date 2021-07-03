class Solution {

    public void rotate(int[] nums, int noOfRotations) {
        if (nums == null || nums.length == 0 || noOfRotations <= 0)
            return;

        noOfRotations = noOfRotations % nums.length;

        swapBetweenIndex(nums, 0, nums.length - 1);
        swapBetweenIndex(nums, 0, noOfRotations - 1);
        swapBetweenIndex(nums,noOfRotations, nums.length - 1);


    }

    private void swapBetweenIndex(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

    }

}