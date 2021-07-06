class TwoSum {


    private final List<Integer> list;
    private boolean isListSorted;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        this.list = new ArrayList<>();
        this.isListSorted = false;
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        this.list.add(number);
        this.isListSorted = false;
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {

        if (!this.isListSorted) {
            Collections.sort(this.list);
            this.isListSorted = true;
        }
        int left = 0;
        int right = this.list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) == value)
                return true;

            if (list.get(left) + list.get(right) < value)
                left++;
            else right--;


        }
        return false;

    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */