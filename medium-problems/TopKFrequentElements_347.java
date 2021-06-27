


class Solution {

    private static class FrequencyCount {
        int number;
        int frequencyCount;

        FrequencyCount(int number, int frequencyCount) {
            this.frequencyCount = frequencyCount;
            this.number = number;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "FrequencyCount{" +
                    "number=" + number +
                    ", frequencyCount=" + frequencyCount +
                    '}';
        }

        public int getFrequencyCount() {
            return this.frequencyCount;
        }

        public int getNumber() {
            return this.number;
        }
    }


    public int[] topKFrequent(int[] inputArray, int noOfFrequentElementsRequired) {

        if (inputArray.length == 0 || noOfFrequentElementsRequired == 0)
            return inputArray;

        HashMap<Integer, Integer> numberToCountMap = new HashMap<>();
        for (int currentNumber : inputArray) {
            numberToCountMap.put(currentNumber, numberToCountMap.getOrDefault(currentNumber, 0) + 1);
        }

        PriorityQueue<FrequencyCount> heap =
                new PriorityQueue<>(Comparator.comparingInt(FrequencyCount::getFrequencyCount));

        int[] output = new int[noOfFrequentElementsRequired];


        for (Map.Entry<Integer, Integer> currentEntry : numberToCountMap.entrySet()) {
            heap.add(new FrequencyCount(currentEntry.getKey(), currentEntry.getValue()));
        }


        while (heap.size() > noOfFrequentElementsRequired)
            heap.poll();

        int outputIndex = 0;
        while (heap.size() > 0) {
            output[outputIndex++] = heap.poll().getNumber();
        }


        return output;
    }
}