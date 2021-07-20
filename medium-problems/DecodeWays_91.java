class Solution {

    public int numDecodings(String inputString) {
        if (inputString.length() <= 1)
            return inputString.length();

        return numDecodingsHelper(inputString, 0);

    }

    private int numDecodingsHelper(String inputString, int currentIndex) {
        if (currentIndex == inputString.length() - 1)
            return 1;


    }

}