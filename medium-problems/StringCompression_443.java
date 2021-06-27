


class Solution {
    public int compress(char[] chars) {
        if (chars.length <= 1)
            return chars.length;


        char[] output = new char[chars.length];
        output[0] = chars[0];
        int indexToPlaceCount = 1;

        int countOfCurrentChar = 1;


        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                countOfCurrentChar++;
            } else {
                while (countOfCurrentChar > 0) {
                    output[indexToPlaceCount++] = (char) ((countOfCurrentChar % 10) + '0');
                    countOfCurrentChar = countOfCurrentChar / 10;
                }
                countOfCurrentChar++;
                output[indexToPlaceCount++] = chars[i];

            }
        }
        while (countOfCurrentChar > 0) {
            output[indexToPlaceCount++] = (char) ((countOfCurrentChar % 10) + '0');
            countOfCurrentChar = countOfCurrentChar / 10;
        }


        System.out.println(output);
        return output.length;

    }
}