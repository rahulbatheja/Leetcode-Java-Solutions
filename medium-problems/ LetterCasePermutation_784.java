


class Solution {
    public List<String> letterCasePermutation(String inputString) {

        if (inputString.length() == 0)
            return new ArrayList<>();

        return letterCasePermutationHelper(inputString, 0);

    }

    private List<String> letterCasePermutationHelper(String inputString, int currentIndex) {
        if (currentIndex == inputString.length())
            return new ArrayList<>(Collections.singletonList(""));


        List<String> output = new ArrayList<>();
        List<String> subProblemResult = letterCasePermutationHelper(inputString, currentIndex + 1);

        char currentChar = inputString.charAt(currentIndex);

        for (int i = 0; i < subProblemResult.size(); i++) {
            /**
             * if currentChar is digit append directly to all subProblemList
             */
            if (currentChar >= '0' && currentChar <= '9')
                output.add(currentChar + subProblemResult.get(i));
            else {
                /**
                 * if alphabet append lowercase as well as upper case to sub solution list
                 */
                output.add(Character.toUpperCase(currentChar) + subProblemResult.get(i));
                output.add(Character.toLowerCase(currentChar) + subProblemResult.get(i));
            }
        }


        return output;
    }
}

