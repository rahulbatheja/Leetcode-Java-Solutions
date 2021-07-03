class Solution {

    private class NumberToDiffMapping {
        int number;
        int differenceWithTargetNumber;

        NumberToDiffMapping(int number, int differenceWithTargetNumber) {
            this.number = number;
            this.differenceWithTargetNumber = differenceWithTargetNumber;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getDifferenceWithTargetNumber() {
            return differenceWithTargetNumber;
        }

        public void setDifferenceWithTargetNumber(int differenceWithTargetNumber) {
            this.differenceWithTargetNumber = differenceWithTargetNumber;
        }
    }


    public List<Integer> findClosestElements(int[] arr, int noOfOuputRequired, int targetNumber) {

        List<Integer> output = new ArrayList<>();
        if (arr.length == 0)
            return output;

        PriorityQueue<NumberToDiffMapping> priorityQueue =
                new PriorityQueue<NumberToDiffMapping>((NumberToDiffMapping a, NumberToDiffMapping b) -> {
                    if (a.getDifferenceWithTargetNumber() != b.getDifferenceWithTargetNumber()) {
                        return Integer.compare(a.getDifferenceWithTargetNumber(),
                                b.getDifferenceWithTargetNumber());

                    } else {
                        return Integer.compare(a.getNumber(), b.getNumber());
                    }
                });


        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(new NumberToDiffMapping(arr[i], Math.abs(targetNumber - arr[i])));
        }

        for (int i = 0; i < noOfOuputRequired; i++)
            output.add(priorityQueue.poll().getNumber());

        Collections.sort(output);
        return output;
    }
}