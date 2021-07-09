class Solution {


    private class NumberPair {
        int row;
        int col;
        int distance;

        @java.lang.Override
        public java.lang.String toString() {
            return "NumberPair{" +
                    "row=" + row +
                    ", col=" + col +
                    ", distance=" + distance +
                    '}';
        }

        NumberPair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};


    private boolean isValid(int newRow, int newCol, int[][] matrix, boolean[][] visited) {
        return newRow < matrix.length && newRow >= 0 && newCol >= 0 && newCol < matrix[0].length &&
                !visited[newRow][newCol];
    }


    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0)
            return mat;


        int[][] output = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<NumberPair> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    output[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new NumberPair(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            NumberPair polledNumber = queue.poll();
            for (int i = 0; i <= 3; i++) {
                if (isValid(polledNumber.row + dx[i], polledNumber.col + dy[i], mat, visited)) {
                    output[polledNumber.row + dx[i]][polledNumber.col + dy[i]] = polledNumber.distance + 1;
                    queue.offer(new NumberPair(polledNumber.row + dx[i], polledNumber.col + dy[i], polledNumber.distance + 1));
                    visited[polledNumber.row + dx[i]][polledNumber.col + dy[i]] = true;
                }
            }
        }


        return output;
    }
}