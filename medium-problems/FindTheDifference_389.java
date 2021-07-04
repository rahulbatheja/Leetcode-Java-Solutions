class Solution {
    public char findTheDifference(String originalString, String mainpulatedString) {


        int[] auxArray = new int[26];
        Arrays.fill(auxArray, 0);
        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);
            auxArray[currentChar - 'a']++;

        }

        for (int i = 0; i < mainpulatedString.length(); i++) {
            char currentChar = mainpulatedString.charAt(i);
            auxArray[currentChar - 'a']--;
        }

        char output = 'a';
        for (int i = 0; i < 26; i++) {
            if (auxArray[i] != 0) {
                output = (char) ('a' + i);
                break;
            }
        }


        return output;
    }
}