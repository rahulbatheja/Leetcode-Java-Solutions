class Solution {
    public String removeDuplicates(String inputString, int k) {
        if (inputString.length() < k)
            return inputString;

        int tempK = k;
        StringBuilder output = new StringBuilder();
        Stack<Character> auxStack = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (auxStack.size() < k - 1) {
                auxStack.push(currentChar);
            } else {
                Stack<Character> tempStack = new Stack<>();
                while (tempK != 1) {
                    char topMostPoppedElement = auxStack.peek();
                    if (topMostPoppedElement == currentChar) {
                        tempStack.push(auxStack.pop());
                    } else {
                        while (!tempStack.isEmpty()) {
                            auxStack.push(tempStack.pop());
                        }
                        auxStack.push(currentChar);
                        break;
                    }
                    tempK--;
                }

                tempK = k;

            }


        }

        while (!auxStack.isEmpty()) {
            output.append(auxStack.pop());
        }

        return output.reverse().toString();
    }
}