class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)
            return 0;

        Stack<Integer> auxStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String cc = tokens[i];
            if ("+-*/".indexOf(cc) == -1)
                auxStack.push(Integer.parseInt(cc));
            else {
                int pop_1 = auxStack.pop();
                int pop_2 = auxStack.pop();
                if (cc.equals("+"))
                    auxStack.push(pop_2 + pop_1);
                else if (cc.equals("-"))
                    auxStack.push(pop_2 - pop_1);
                else if (cc.equals("*"))
                    auxStack.push(pop_2 * pop_1);
                else if (cc.equals("/"))
                    auxStack.push(pop_2 / pop_1);

            }

        }

        return auxStack.pop();

    }
}