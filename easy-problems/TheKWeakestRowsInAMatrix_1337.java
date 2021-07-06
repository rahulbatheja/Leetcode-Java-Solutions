class Solution {

    private class RowWithStrength {
        int row;
        int strength;

        RowWithStrength(int row, int strength) {
            this.row = row;
            this.strength = strength;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat.length == 0 || k == 0)
            return new int[0];


        PriorityQueue<RowWithStrength> priorityQueue = new PriorityQueue<>((RowWithStrength firstObject, RowWithStrength secondObeject) -> {

            if (firstObject.getStrength() != secondObeject.strength)
                return Integer.compare(secondObeject.getStrength(), firstObject.getStrength());
            else
                return Integer.compare(secondObeject.getRow(), firstObject.getRow());

        }

        );

        for (int i = 0; i < mat.length; i++) {
            int strength = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    strength++;
                } else break;
            }
            if (priorityQueue.size() < k) {
                priorityQueue.offer(new RowWithStrength(i, strength));
            } else {
                if (strength < priorityQueue.peek().getStrength()) {
                    priorityQueue.poll();
                    priorityQueue.offer(new RowWithStrength(i, strength));
                }

            }
        }

        int[] output = new int[k];
        int index = output.length - 1;
        while (!priorityQueue.isEmpty()) {
            output[index--] = priorityQueue.poll().row;
        }

        return output;

    }
}