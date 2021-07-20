class Solution {
    public int[][] highFive(int[][] items) {

        if (items == null || items.length <= 1)
            return items;



        HashMap<Integer, PriorityQueue<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < items.length; i++) {
            if (!hashMap.containsKey(items[i][0])) {
                hashMap.put(items[i][0], new PriorityQueue<>());
            }
            PriorityQueue<Integer> scoresOfCurrentStudent = hashMap.get(items[i][0]);
            scoresOfCurrentStudent.offer(items[i][1]);
            if (scoresOfCurrentStudent.size() > 5)
                scoresOfCurrentStudent.poll();

        }

        ArrayList<Integer> stduentIds = new ArrayList<>(hashMap.keySet());
        stduentIds.sort(Comparator.naturalOrder());

        int[][] output = new int[stduentIds.size()][2];

        int outputIndex = 0;
        for (int studentId : stduentIds) {
            PriorityQueue<Integer> listOfScores = hashMap.get(studentId);
            int sum = 0;
            while (!listOfScores.isEmpty()) {
                sum += listOfScores.poll();
            }
            output[outputIndex][0] = studentId;
            output[outputIndex][1] = sum / 5;
            outputIndex++;
        }

        return output;

    }
}