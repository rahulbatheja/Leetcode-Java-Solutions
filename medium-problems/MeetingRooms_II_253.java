class Solution {

    private class Pair {
        int startTime;
        int endTime;

        public Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Pair{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }


    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1)
            return 1;


        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getEndTime));
        int roomCount = 1;
        priorityQueue.offer(new Pair(intervals[0][0], intervals[0][1]));
        for (int i = 1; i < intervals.length; i++) {
            int currentMeetingStartTime = intervals[i][0];
            if (priorityQueue.peek().getEndTime() <= currentMeetingStartTime) {
                priorityQueue.poll();
            } else {
                roomCount++;
            }

            priorityQueue.offer(new Pair(intervals[i][0], intervals[i][1]));
        }


        return roomCount;
    }
}