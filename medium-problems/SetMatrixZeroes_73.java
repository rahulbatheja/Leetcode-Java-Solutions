class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;


        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    list.add(new Pair(i, j));
            }
        }

        for (Pair currentPair : list) {
            int currentRow = currentPair.getRow();
            int currentCol = currentPair.getCol();
            for (int i = 0; i < matrix[0].length; i++)
                matrix[currentRow][i] = 0;
            for (int i = 0; i < matrix.length; i++)
                matrix[i][currentCol] = 0;

        }


    }


    private class Pair {
        private int row;
        private int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

}