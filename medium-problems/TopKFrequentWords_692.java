class Solution {

    private static class WordToFreq {
        String word;
        int frequency;

        public WordToFreq(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }


    public List<String> topKFrequent(String[] words, int k) {

        List<String> output = new ArrayList<>();
        if (words.length <= 1) {
            output.add(words[0]);
            return output;
        }

        HashMap<String, Integer> auxMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            auxMap.put(words[i], auxMap.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<WordToFreq> priorityQueue =
                new PriorityQueue<>((firstWord, seconWord) -> {
                    if (firstWord.getFrequency() != seconWord.getFrequency())
                        return Integer.compare(firstWord.getFrequency(), seconWord.getFrequency());
                    else {
                        return seconWord.getWord().compareTo(firstWord.getWord());
                    }
                });


        for (Map.Entry<String, Integer> currentEntry : auxMap.entrySet()) {
            priorityQueue.offer(new WordToFreq(currentEntry.getKey(), currentEntry.getValue()));
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }

        while (!priorityQueue.isEmpty())
            output.add(0, priorityQueue.poll().getWord());

        return output;

    }
}