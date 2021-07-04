class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        if (image.length <= 1)
            return image;


        for (int i = 0; i < image.length; i++)
            reverseRow(image, i);
        return image;
    }

    private void reverseRow(int[][] image, int currentRow) {

        int left = 0;
        int right = image.length - 1;
        while (left <= right) {
            int temp = image[currentRow][left];
            image[currentRow][left] = image[currentRow][right];
            image[currentRow][right] = temp;

            left++;
            right--;

            /**
             * flip digits
             */
            if (image[currentRow][left] == 0)
                image[currentRow][left] = 1;
            else
                image[currentRow][left] = 0;

            if (image[currentRow][right] == 0)
                image[currentRow][right] = 1;
            else
                image[currentRow][right] = 0;


        }


    }

}