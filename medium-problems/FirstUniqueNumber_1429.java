class FirstUnique {


    private Queue<Integer> queue;
    private HashMap<Integer, Boolean> hashMap;

    FirstUnique() {
        this.queue = new LinkedList<>();
        this.hashMap = new HashMap<>();
    }

    public FirstUnique(int[] nums) {
        this();
        for (int currentNumber : nums)
            add(currentNumber);
    }

    public int showFirstUnique() {

        while (!queue.isEmpty() && !hashMap.get(queue.peek())) {
            queue.poll();
        }
        if (!queue.isEmpty())
            return queue.peek();

        return -1;
    }

    public void add(int value) {
        if (hashMap.containsKey(value))
            hashMap.put(value, false);
        else {
            hashMap.put(value, true);
            queue.offer(value);
        }


    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */