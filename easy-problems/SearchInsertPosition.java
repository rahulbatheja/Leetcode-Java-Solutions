


class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (target < nums[0])
                return 0;
            else return 1;
        }

/**
 * apply normal binary search approch
 * just maintain a lower bound of the target(because if target is not found than lowerBound+1 index will be the answer)
 */
        int left = 0;
        int right = nums.length - 1;
        int lowerBoundIndex = -1;
        while (left < right) {

            int mid = (right - left) / 2 + (left);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                /**
                 * maintaining a lower bound Index, in case target is not present in provided array
                 */
                lowerBoundIndex = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return lowerBoundIndex + 1;

    }
}