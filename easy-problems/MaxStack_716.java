class MaxStack {


    private final Stack<Integer> maxStack;
    private final Stack<Integer> actualStack;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        this.actualStack = new Stack<>();
        this.maxStack = new Stack<>();

    }

    public void push(int val) {

        if (actualStack.isEmpty()) {
            this.actualStack.push(val);
            this.maxStack.push(val);
        } else {
            this.actualStack.push(val);
            if (this.maxStack.peek() < val)
                this.maxStack.push(val);
            else this.maxStack.push(this.maxStack.peek());

        }

    }

    public int pop() {
        this.maxStack.pop();
        return this.actualStack.pop();
    }

    public int top() {
        return this.actualStack.peek();
    }

    public int peekMax() {
        return this.maxStack.peek();
    }

    public int popMax() {
        int maxElement = this.maxStack.peek();

        Stack<Integer> buffer = new Stack<>();
        while (!this.actualStack.isEmpty() && this.actualStack.peek() != maxElement) {
            buffer.push(this.pop());
        }
        if (!this.actualStack.isEmpty()) {
            this.pop();
        }

        while (!buffer.isEmpty()) {
            this.push(buffer.pop());
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