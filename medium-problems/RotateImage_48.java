class Solution {
    public void rotate(int[][] matrix) {

        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return;

        getTransposeOfMatrix(matrix);
        swapRowsFromEndToMiddle(matrix);

    }

    private void swapRowsFromEndToMiddle(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            for (int i = 0; i < matrix.length; i++) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }

    private void getTransposeOfMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ( i < j) {
                    swap(matrix, i, j);
                }

            }
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}