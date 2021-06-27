


class Solution {

    private static class CharacterFreq {

        private char character;
        private int frequencey;

        public CharacterFreq(char character, int frequencey) {
            this.character = character;
            this.frequencey = frequencey;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public int getFrequencey() {
            return frequencey;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "CharacterFreq{" +
                    "character=" + character +
                    ", frequencey=" + frequencey +
                    '}';
        }

        public void setFrequencey(int frequencey) {
            this.frequencey = frequencey;
        }
    }

    public String frequencySort(String inputString) {

        if (inputString.length() <= 1)
            return inputString;


        StringBuilder output = new StringBuilder();

        HashMap<Character, Integer> characterCount = new HashMap<>();

        for (int i = 0; i < inputString.length(); i++) {
            characterCount.put(inputString.charAt(i),
                    characterCount.getOrDefault(inputString.charAt(i), 0) + 1);
        }


        PriorityQueue<CharacterFreq> maxHeap = new PriorityQueue<>(
                Comparator.comparingInt(CharacterFreq::getFrequencey).reversed()
        );

        for (Map.Entry<Character, Integer> currentEntry : characterCount.entrySet()) {
            maxHeap.add(new CharacterFreq(currentEntry.getKey(), currentEntry.getValue()));
        }

        while (maxHeap.size() > 0) {
            CharacterFreq maxFreqElement = maxHeap.poll();
            char maxFreqChar = maxFreqElement.getCharacter();
            int countOfMaxFeq = maxFreqElement.getFrequencey();
            while (countOfMaxFeq != 0) {
                output.append(maxFreqChar);
                countOfMaxFeq--;
            }

        }


        return output.toString();

    }
}