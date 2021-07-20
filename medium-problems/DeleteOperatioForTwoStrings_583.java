class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0)
            return word2.length();
        else if (word2.length() == 0)
            return word1.length();

        int[][] auxSpace = new int[word1.length()][word2.length()];
        for (int[] currRow : auxSpace)
            Arrays.fill(currRow, -1);

        return minDistanceHelper(word1, word2, 0, 0, auxSpace);
    }

    private int minDistanceHelper(String word1, String word2, int firstIndex, int secondIndex, int[][] auxSpace) {
        if (firstIndex == word1.length())
            return word2.length() - secondIndex;

        if (secondIndex == word2.length())
            return word1.length() - firstIndex;

        if (auxSpace[firstIndex][secondIndex] != -1)
            return auxSpace[firstIndex][secondIndex];


        if (word1.charAt(firstIndex) == word2.charAt(secondIndex)) {
            auxSpace[firstIndex][secondIndex] = minDistanceHelper(word1, word2, firstIndex + 1, secondIndex + 1, auxSpace);
            return auxSpace[firstIndex][secondIndex];
        }


        auxSpace[firstIndex][secondIndex] = 1 + Math.min(minDistanceHelper(word1, word2, firstIndex + 1, secondIndex, auxSpace),
                minDistanceHelper(word1, word2, firstIndex, secondIndex + 1, auxSpace));
        return auxSpace[firstIndex][secondIndex];
    }


}