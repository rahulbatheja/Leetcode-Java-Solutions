class Twitter {


    private class TweetWithTimeStamp {
        int tweetId;
        int timeStamp;

        TweetWithTimeStamp(int timeStamp, int tweetId) {
            this.timeStamp = timeStamp;
            this.tweetId = tweetId;
        }

        public int getTweetId() {
            return tweetId;
        }

        public void setTweetId(int tweetId) {
            this.tweetId = tweetId;
        }

        public int getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(int timeStamp) {
            this.timeStamp = timeStamp;
        }
    }

    private int currentTime;
    private HashMap<Integer, Set<Integer>> followers;

    private HashMap<Integer, List<TweetWithTimeStamp>> userPosts;


    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followers = new HashMap<>();
        userPosts = new HashMap<>();
        this.currentTime = 1;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

        List<TweetWithTimeStamp> currentUserTweets = this.userPosts.getOrDefault(userId, new ArrayList<>());
        currentUserTweets.add(new TweetWithTimeStamp(this.currentTime, tweetId));
        this.userPosts.put(userId, currentUserTweets);
        this.currentTime++;


    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        Set<Integer> followingUserIds = this.followers.getOrDefault(userId, new HashSet<>());
        followingUserIds.add(userId);


        List<TweetWithTimeStamp> feedTweetsToShow = new ArrayList<>();

        for (Integer currentUserId : followingUserIds) {
            feedTweetsToShow.addAll(this.userPosts.getOrDefault(currentUserId, new ArrayList<>()));
        }

        feedTweetsToShow.sort(Comparator.comparingInt(TweetWithTimeStamp::getTimeStamp).reversed());

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < 10 && i < feedTweetsToShow.size(); i++) {
            output.add(feedTweetsToShow.get(i).getTweetId());
        }

        return output;

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

        Set<Integer> currentSet = this.followers.getOrDefault(followerId, new HashSet<Integer>());
        currentSet.add(followeeId);
        this.followers.put(followerId, currentSet);


    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

        Set<Integer> currentSet = this.followers.getOrDefault(followerId, new HashSet<Integer>());
        if (!currentSet.isEmpty()) {
            currentSet.remove(followeeId);
            this.followers.put(followerId, currentSet);
        }


    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */