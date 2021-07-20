class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0)
            return 0;

        int[][] auxSpace = new int[text1.length() + 1][text2.length() + 1];
        for (int[] currArr : auxSpace)
            Arrays.fill(currArr, 0);

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    auxSpace[i][j] = 1 + auxSpace[i - 1][j - 1];
                else
                    auxSpace[i][j] = Math.max(auxSpace[i - 1][j], auxSpace[i][j - 1]);
            }
        }

        return auxSpace[text1.length()][text2.length()];

    }
}