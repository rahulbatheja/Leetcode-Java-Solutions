class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 && board[0].length != 9)
            return false;

        if (!checkAreRowsValid(board))
            return false;
        if (!checkAreColsValid(board))
            return false;
        return check_3_By_3_boxes(board);


    }

    private boolean check_3_By_3_boxes(char[][] board) {
        HashSet<Character> auxSet = new HashSet<>();

        int rowStart = 0;
        while (rowStart < 9) {
            int colStart = 0;
            while (colStart < 9) {
                for (int row = rowStart; row < rowStart + 3; row++) {
                    for (int col = colStart; col < colStart + 3; col++) {
                        char currentChar = board[row][col];
                        if (auxSet.contains(currentChar))
                            return false;
                        else if (currentChar != '.')
                            auxSet.add(currentChar);
                    }
                }
                auxSet.clear();
                colStart = colStart + 3;
            }

            rowStart = rowStart + 3;
        }
        return true;
    }


    private boolean checkAreColsValid(char[][] board) {
        HashSet<Character> auxSet = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                char currentChar = board[row][col];

                if (auxSet.contains(currentChar))
                    return false;
                else if (currentChar != '.')
                    auxSet.add(currentChar);
            }

            auxSet.clear();
        }

        return true;

    }

    private boolean checkAreRowsValid(char[][] board) {

        HashSet<Character> auxSet = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char currentChar = board[row][col];

                if (auxSet.contains(currentChar))
                    return false;
                else if (currentChar != '.')
                    auxSet.add(currentChar);
            }

            auxSet.clear();
        }

        return true;
    }

}