


class Solution {
    public int[] frequencySort(int[] inputArray) {

        if (inputArray.length <= 1)
            return inputArray;
        HashMap<Integer, Integer> numberToFreqMap = new HashMap<>();
        for (int currentNumber : inputArray) {
            numberToFreqMap.put(currentNumber, numberToFreqMap.getOrDefault(currentNumber, 0) + 1);
        }


        int maxFreq = Collections.max(numberToFreqMap.values());

        ArrayList<Integer>[] buckets = new ArrayList[maxFreq + 1];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> currentEntry : numberToFreqMap.entrySet()) {
            buckets[currentEntry.getValue()].add(currentEntry.getKey());
        }

        System.out.println(Arrays.toString(buckets));

        int outputIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            ArrayList<Integer> numbersOfFreq_i_present = buckets[i];

            numbersOfFreq_i_present.sort(Collections.reverseOrder());

            for (int k = 0; k < numbersOfFreq_i_present.size(); k++) {

                int currentNumber = numbersOfFreq_i_present.get(k);
                for (int j = 1; j <= i; j++) {
                    inputArray[outputIndex++] = currentNumber;

                }
            }
        }


        return inputArray;
    }
}