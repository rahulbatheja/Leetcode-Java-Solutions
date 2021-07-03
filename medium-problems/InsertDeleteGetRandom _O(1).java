class RandomizedSet {


    private HashMap<Integer, Integer> keyToIndexMap;
    private ArrayList<Integer> keyList;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        hashSet = new HashMap<>();
        keyList = new ArrayList<>();

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (keyToIndexMap.containsKey(val))
            return false;
        else {

            keyToIndexMap.put(val, keyList.size());
            keyList.add(keyList.size(),val);
            return true;

        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {

        if (!keyToIndexMap.containsKey(val))
            return false;
        else {
            int indexInListToRemove = keyToIndexMap.get(val);
            removeGivenIndexFromList(indexInListToRemove);
            keyToIndexMap.remove(val);
            return true;
        }


    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

    }

    private void removeGivenIndexFromList(int indexToRemove) {
        keyList.set(indexToRemove, keyList.get(keyList.size() - 1));
        keyToIndexMap.put(keyList.get(keyList.size() - 1), indexToRemove);
        keyList.remove(keyList.size() - 1);

    }


}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */