class Solution {
    public List<List<String>> solveNQueens(int chessBoardSize) {

        if (chessBoardSize <= 0)
            return new ArrayList<>();

        char[][] chessBoard = new char[chessBoardSize][chessBoardSize];
        for (int i = 0; i < chessBoardSize; i++) {
            for (int j = 0; j < chessBoardSize; j++)
                chessBoard[i][j] = '.';
        }

        solveNQueensHelper(chessBoard, 0, 0);
        return null;

    }

    private void printChessBoard(char[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++)
                System.out.println(chessBoard[i][j]);
        }

    }

    private void solveNQueensHelper(char[][] chessBoard, int currentRow, int currentCol) {
        if (currentRow > chessBoard.length || currentCol > chessBoard.length)
            return;
        if (currentRow == chessBoard.length && currentCol == chessBoard.length) {
            printChessBoard(chessBoard);
        }
        for (int i = currentRow; i < chessBoard.length; i++) {
            for (int j = currentCol; j < chessBoard.length; j++) {
                if (checkBoardRow(chessBoard, i)
                        && checkBoardCol(chessBoard, j)
                        && checkUpperLeftAndRightDiagonal(chessBoard, i, j)) {
                    chessBoard[i][j] = 'Q';
                    solveNQueensHelper(chessBoard, i + 1, j);
                    chessBoard[i][j] = '.';
                }


            }
        }


    }


    private boolean checkBoardRow(char[][] board, int row) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q')
                return false;
        }
        return true;
    }

    private boolean checkBoardCol(char[][] board, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        return true;
    }

    private boolean checkUpperLeftAndRightDiagonal(char[][] board, int row, int col) {

        int tempRow = row;
        int tempCol = col;
        while (tempRow >= 0 && tempCol >= 0) {
            if (board[tempRow][tempCol] == 'Q')
                return false;

            tempRow--;
            tempCol--;
        }
        tempRow = row;
        tempCol = col;
        while (row >= 0 && col < board.length) {
            if (board[row][col] == 'Q')
                return false;
            col++;
            row--;
        }
        return true;


    }


}