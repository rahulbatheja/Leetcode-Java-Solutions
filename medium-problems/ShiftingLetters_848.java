class Solution {
    public String shiftingLetters(String inputString, int[] shifts) {
        if (inputString.length() == 0 || shifts.length == 0)
            return inputString;

        StringBuilder sb = new StringBuilder(inputString);
        for (int i = 0; i < shifts.length; i++) {
            int shiftByChar = shifts[i];
            for (int j = 0; j <= i; j++) {
                sb.setCharAt(j, (char) (sb.charAt(j) + shiftByChar));
            }

        }


        return sb.toString();
    }
}