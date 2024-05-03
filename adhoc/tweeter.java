import java.util.*;

class Twitter {

    List<Post> globalPostList;
    Map<Integer, User> globalUserMap;

    public Twitter() {
        globalPostList = new ArrayList<>();
        globalUserMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        globalUserMap.putIfAbsent(userId, new User(userId));
        Post post = new Post(tweetId, userId);
        globalPostList.add(0, post);
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!globalUserMap.containsKey(userId)) return new ArrayList<>();

        int count = 0;
        List<Integer> feed = new ArrayList<>();
        User user = globalUserMap.get(userId);
        Set following = user.following;
        int size = globalPostList.size();

        for (int i = 0; i < size && count < 10; i++) {
            Post post = globalPostList.get(i);
            int author = post.userId;
            if(following.contains(author)) {
                feed.add(post.postId);
                count++;
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        globalUserMap.putIfAbsent(followerId, new User(followerId));
        globalUserMap.putIfAbsent(followeeId, new User(followeeId));

        User follower = globalUserMap.get(followerId);
        User followee = globalUserMap.get(followeeId);

        follower.following.add(followeeId);
        followee.followers.add(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        globalUserMap.putIfAbsent(followerId, new User(followerId));
        globalUserMap.putIfAbsent(followeeId, new User(followeeId));

        User follower = globalUserMap.get(followerId);
        User followee = globalUserMap.get(followeeId);

        follower.following.remove(followeeId);
        followee.followers.remove(followerId);
    }

    public static void main(String[] args) {

        // ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
        // [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1,2);
        twitter.getNewsFeed(1);

    }
}

class User{
    int userId;
    Set<Integer> followers;
    Set<Integer> following;

    User(int id) {
        this.userId = id;
        followers = new HashSet();
        following = new HashSet();
        following.add(id);
    }
}

class Post{
    int postId, userId;

    Post(int postId, int userId){
        this.postId = postId;
        this.userId = userId;
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

// ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
// [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]