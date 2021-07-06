class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if (mat.length == 0 || (mat.length * mat[0].length != r * c))
            return mat;

        int[][] newMatrix = new int[r][c];
        int[] new_1dArray = new int[mat.length * mat[0].length];
        int index = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                new_1dArray[index++] = mat[i][j];
            }
        }
        index = 0;
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = new_1dArray[index++];
            }
        }

        return newMatrix;
    }
}