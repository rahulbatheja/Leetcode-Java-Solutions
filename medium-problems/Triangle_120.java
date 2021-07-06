class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);


        int[][] auxSpace = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] currentRow : auxSpace)
            Arrays.fill(currentRow, Integer.MAX_VALUE);

        minimumTotalHelper(triangle, 0, 0, auxSpace);

        return auxSpace[0][0];
    }

    private int minimumTotalHelper(List<List<Integer>> triangle, int currentRow, int currentCol,
                                   int[][] auxSpace) {

        if (currentRow == triangle.size())
            return 0;

        if (auxSpace[currentRow][currentCol] != Integer.MAX_VALUE)
            return auxSpace[currentRow][currentCol];

        int includeIthIndex = minimumTotalHelper(triangle, currentRow + 1, currentCol, auxSpace);
        int includeIthPlusIndex =
                minimumTotalHelper(triangle, currentRow + 1, currentCol + 1, auxSpace);

        auxSpace[currentRow][currentCol] = triangle.get(currentRow).get(currentCol) + Math.min(includeIthIndex, includeIthPlusIndex);
        return auxSpace[currentRow][currentCol];

    }

}