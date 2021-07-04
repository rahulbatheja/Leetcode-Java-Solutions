class Solution {
    public int[][] transpose(int[][] matrix) {
        if (matrix.length <= 1)
            return matrix;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }

            }

        }


        return matrix;
    }
}