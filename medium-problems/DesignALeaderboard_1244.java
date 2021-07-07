class Leaderboard {


    private final HashMap<Integer, Integer> playerToScoreMap;
    private List<Integer> sortedValues;
    private boolean isSorted;

    public Leaderboard() {
        this.isSorted = false;
        this.playerToScoreMap = new HashMap<Integer, Integer>();
        this.sortedValues = new ArrayList<>();
    }

    public void addScore(int playerId, int score) {
        this.playerToScoreMap.put(playerId, this.playerToScoreMap.getOrDefault(playerId, 0) + score);
        this.isSorted = false;
    }

    public int top(int K) {
        List<Integer> scores;
        if (this.isSorted) {
            scores = this.sortedValues;
        } else {
            scores = new ArrayList<>(this.playerToScoreMap.values());
            scores.sort(Collections.reverseOrder());
            this.isSorted = true;
            this.sortedValues = scores;
        }

        int sum = 0;
        for (int i = 0; i < K; i++)
            sum += scores.get(i);

        return sum;
    }

    public void reset(int playerId) {
        this.playerToScoreMap.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */