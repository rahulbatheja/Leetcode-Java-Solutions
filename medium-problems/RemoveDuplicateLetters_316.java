class Solution {
    public String removeDuplicateLetters(String inputString) {

        int[] auxSpace = new int[26];
        Arrays.fill(auxSpace, -1);
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (auxSpace[currentChar - 'a'] == -1)
                auxSpace[currentChar - 'a'] = 1;
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < auxSpace.length; i++) {
            if (auxSpace[i] != -1)
                output.append((char) (i + 'a'));
        }

        return output.toString();

    }
}