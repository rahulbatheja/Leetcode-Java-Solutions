


class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;


        int endPointer = nums.length-1;

        for (int i = 0; i <= endPointer; ) {
            if (nums[i] == val) {
                swap(nums, i, endPointer);
                endPointer--;
            } else
                i++;
        }

        return endPointer+1;
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}