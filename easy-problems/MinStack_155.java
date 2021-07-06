class MinStack {


    private final Stack<Integer> minStack;
    private final Stack<Integer> actualStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

        this.minStack = new Stack<>();
        this.actualStack = new Stack<>();

    }

    public void push(int val) {
        if (actualStack.isEmpty()) {
            this.actualStack.push(val);
            this.minStack.push(val);
        } else {
            this.actualStack.push(val);
            if (this.minStack.peek() > val)
                this.minStack.push(val);
            else this.minStack.push(this.minStack.peek());

        }


    }

    public void pop() {
        this.minStack.pop();
        this.actualStack.pop();

    }

    public int top() {
        return this.actualStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */