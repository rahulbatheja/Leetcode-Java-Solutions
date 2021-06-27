


class Solution {

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    private static class CustomPair {
        int x;
        int y;

        CustomPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (m == 0 || n == 0 || maxMove == 0)
            return 0;

        boolean[][] visited = new boolean[m][n];

        m--;
        n--;

        return (int) (traverseUsingBFS(m, n, maxMove, startRow, startColumn, visited) % 100000007);

    }

    private boolean isOutOfBoundry(int currentRow, int currentCol, int endRow, int endCol) {
        return currentRow < 0 || currentCol < 0 || currentRow > endRow || currentCol > endCol;
    }


    private long traverseUsingBFS(int endRow, int endCol, int maxMove, int currentRow, int currentCol, boolean[][] visited) {

        Queue<CustomPair> auxQueue = new LinkedList<>();
        auxQueue.add(new CustomPair(currentRow, currentCol));
        visited[currentRow][currentCol] = true;

        long count = 0;
        while (!auxQueue.isEmpty() && maxMove > 0) {

            int currentQueueSize = auxQueue.size();
            CustomPair poppedOutPair = auxQueue.poll();
            while (currentQueueSize > 0) {
                for (int i = 0; i <= 3; i++) {
                    int newX = poppedOutPair.x + dx[i];
                    int newY = poppedOutPair.y + dy[i];
                    if (isOutOfBoundry(newX, newY, endRow, endCol))
                        count++;
                    else {
                        auxQueue.add(new CustomPair(newX, newY));
                    }
                }
                currentQueueSize--;
            }
            maxMove--;
        }
        return count;
    }


}