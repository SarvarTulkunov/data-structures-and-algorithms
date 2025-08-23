package leetcode;

import java.util.*;

/**
 * 355. Design Twitter
 */
class Twitter {

    private int count = 0;
    private final HashMap<Integer, Set<Integer>> users;
    private final HashMap<Integer, List<Pair<Integer, Integer>>> userTweets;

    public Twitter() {
        count++;
        users = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Pair<>(count++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        users.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followeeId : users.get(userId)) {
            if (userTweets.containsKey(followeeId)) {
                List<Pair<Integer, Integer>> tweets = userTweets.get(followeeId);
                int index = tweets.size() - 1;
                Pair<Integer, Integer> tweet = tweets.get(index);
                maxHeap.offer(new int[]{tweet.key(), tweet.value(), followeeId, index});
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] curr = maxHeap.poll();
            res.add(curr[1]);
            int index = curr[3];

            if (index > 0) {
                Pair<Integer, Integer> tweet = userTweets.get(curr[2]).get(index - 1);
                maxHeap.offer(new int[]{tweet.key(), tweet.value(), curr[2], index - 1});
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        users.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            users.get(followerId).remove(followeeId);
        }
    }
}
