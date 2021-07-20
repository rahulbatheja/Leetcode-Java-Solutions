class Solution {
    public boolean checkValidString(String inputString) {

        if (inputString.length() == 0)
            return true;


        Stack<Character> braces = new Stack<>();
        Stack<Character> stars = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            char cc = inputString.charAt(i);
            if (cc == '(') {
                braces.push()
            } else if (cc == '*') {

            } else if (cc == ')') {

            }
        }
    }
}