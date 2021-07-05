class MyStack {

    private final Queue<Integer> mainQueue;
    private final Queue<Integer> auxQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.mainQueue = new LinkedList<>();
        this.auxQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (mainQueue.isEmpty()) {
            mainQueue.offer(x);
        } else {
            while (!mainQueue.isEmpty()) {
                auxQueue.offer(mainQueue.poll());
            }

            mainQueue.offer(x);
            while (!auxQueue.isEmpty()) {
                mainQueue.offer(auxQueue.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return mainQueue.poll();

    }

    /**
     * Get the top element.
     */
    public int top() {
        return mainQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */