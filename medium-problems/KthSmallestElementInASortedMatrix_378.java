class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0)
            return -1;
        if (matrix.length == 1)
            return matrix[0][0];

        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Tuple::getValue));

        for (int i = 0; i < matrix.length; i++) {
            priorityQueue.offer(new Tuple(0, i, matrix[i][0]));
        }
        while (k > 1) {

            Tuple removedTuple = priorityQueue.poll();

            if (removedTuple.getIndex() + 1 < matrix.length)
                priorityQueue.offer(new Tuple(removedTuple.index + 1, removedTuple.row,
                        matrix[removedTuple.row][removedTuple.index + 1]));
            k--;
        }
        return priorityQueue.poll().getValue();

    }


    private class Tuple {
        int index;
        int row;
        int value;

        public String toString() {
            return String.valueOf(this.value);
        }

        public Tuple(int index, int row, int value) {
            this.index = index;
            this.row = row;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }
    }


}