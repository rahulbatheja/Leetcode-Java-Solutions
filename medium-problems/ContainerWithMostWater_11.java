


class Solution {
    public int maxArea(int[] heights) {

        if (heights.length <= 1)
            return 0;


        int max = 0;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;

        while (leftPointer < rightPointer) {
            int width = rightPointer - leftPointer;
            int height = Math.min(heights[leftPointer], heights[rightPointer]);

            int waterContained = height * width;
            max = Math.max(max, waterContained);
            if (heights[leftPointer] < heights[rightPointer])
                leftPointer++;
            else rightPointer--;

        }


        return max;

    }
}