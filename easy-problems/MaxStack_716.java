class MaxStack {


    private final Stack<Integer> auxStack;
    //private final Stack<Integer> maxStack;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        this.auxStack = new Stack<>();
        // this.maxStack = new Stack<>();
    }

    public void push(int x) {
        auxStack.push(x);

    }

    public int pop() {
        return auxStack.pop();
    }

    public int top() {
        return auxStack.peek();
    }

    public int peekMax() {

        Stack<Integer> tempStack = new Stack<>();
        int maxElement = Integer.MIN_VALUE;
        while (!this.auxStack.isEmpty()) {
            int poppedElement = this.auxStack.pop();
            maxElement = Math.max(maxElement, poppedElement);
            tempStack.push(poppedElement);
        }
        while (!tempStack.isEmpty()) {
            auxStack.push(tempStack.pop());
        }

        return maxElement;
    }

    public int popMax() {

        Stack<Integer> tempStack = new Stack<>();
        int maxElement = Integer.MIN_VALUE;
        while (!this.auxStack.isEmpty()) {
            int poppedElement = this.auxStack.pop();
            maxElement = Math.max(maxElement, poppedElement);
            tempStack.push(poppedElement);
        }

        int countOfMaxElement = 0;
        for (Integer currentNumber : tempStack) {
            if (currentNumber == maxElement)
                countOfMaxElement++;
        }

        while (!tempStack.isEmpty()) {
            int poppedElement = tempStack.pop();
            if (poppedElement == maxElement) {
                if (countOfMaxElement > 1) {
                    this.auxStack.push(poppedElement);
                    countOfMaxElement--;
                }

            } else
                this.auxStack.push(poppedElement);

        }

        return maxElement;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */