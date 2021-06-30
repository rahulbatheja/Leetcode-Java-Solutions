



class Solution {
    public String removeDuplicates(String inputString) {
        if(inputString.length()<=1)
            return inputString;


        StringBuilder output = new StringBuilder();
        Stack<Character> auxSpace = new Stack<>();

        for (int i=0;i<inputString.length();i++)
        {
            char currentChar = inputString.charAt(i);
            if (auxSpace.isEmpty())
                auxSpace.push(currentChar);
            else
            {
                if (auxSpace.peek()==currentChar)
                    auxSpace.pop();
                else
                    auxSpace.push(currentChar);
            }

        }
        while (!auxSpace.isEmpty())
            output.append(auxSpace.pop());

        return output.reverse().toString();

    }
}