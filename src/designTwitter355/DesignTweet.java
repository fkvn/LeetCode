package designTwitter355;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignTweet {
	public static void main(String[] args) throws InterruptedException {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		twitter.postTweet(1, 3);
		twitter.postTweet(1, 101);
		twitter.postTweet(1, 13);
		twitter.postTweet(1, 10);
		twitter.postTweet(1, 2);
		twitter.postTweet(1, 94);
		twitter.postTweet(1, 505);
		twitter.postTweet(1, 333);
		twitter.postTweet(1, 22);
		twitter.postTweet(1, 11);

		System.out.println("\nGet new Feed User 1: ");
		List<Integer> tweetsUser = twitter.getNewsFeed(1);
		for (int i = 0; i < tweetsUser.size(); i++) {
			System.out.print(tweetsUser.get(i) + " ");
		}
	}
}

class Twitter {
	
	ArrayList<User> users;
	
	public static int twtId = 0;
	
    /** Initialize your data structure here. */
    public Twitter() {
        this.users = new ArrayList<User>();
    }
    
    /** Compose a new tweet. 
     * @throws InterruptedException */
    public void postTweet(int userId, int tweetId)  {
    	
        if (User.containUser(users, userId))
        {
        	users.get(User.getIndex(users, userId)).addTweet(Twitter.twtId++, tweetId);
        }
        
        else {
        	User user = new User(userId);
        	user.addTweet(Twitter.twtId++, tweetId);
        	users.add(user);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	if (!User.containUser(users, userId)) {
    		User user = new User(userId);
    		users.add(user);
    	}
    		
    	
		User user = users.get(User.getIndex(users, userId));
		ArrayList<User> follows = user.getFollows();
		Map<Integer, Integer>  tweets = new HashMap<Integer, Integer>();
		tweets.putAll(user.getTweets());
		
		for (int i = 0; i < follows.size(); i++) {
			for (Map.Entry<Integer, Integer> entry : follows.get(i).getTweets().entrySet()) {
				tweets.put(entry.getKey(), entry.getValue());
			}
		}
		
		Map<Integer, Integer> sortedTweets = null;
		
		if(tweets != null)
			sortedTweets = new TreeMap<Integer, Integer>(tweets);
		List<Integer> newsFeed = new ArrayList<Integer>();
		
       for (Map.Entry<Integer, Integer> entry : sortedTweets.entrySet()) {
				newsFeed.add(entry.getValue());
        }
		
		Collections.reverse(newsFeed);
		
		if (newsFeed.size() > 10)
			return newsFeed.subList(0, 10);
		else
			return newsFeed;
		
		
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if (User.containUser(users, followerId) && followerId != followeeId) {
    		if (User.containUser(users, followeeId))
    			users.get(User.getIndex(users, followerId)).addFollow(users.get(User.getIndex(users, followeeId)));
    		else {
    			User followee = new User(followeeId);
    			users.add(followee);
    			users.get(User.getIndex(users, followerId)).addFollow(users.get(User.getIndex(users, followeeId)));
    		}
    	}
    	else {
    		User user = new User(followerId);
			users.add(user);
			
			if (User.containUser(users, followeeId))
    			users.get(User.getIndex(users, followerId)).addFollow(users.get(User.getIndex(users, followeeId)));
    		else {
    			User followee = new User(followeeId);
    			users.add(followee);
    			users.get(User.getIndex(users, followerId)).addFollow(users.get(User.getIndex(users, followeeId)));
    		}
    	}
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if (User.containUser(users, followerId)) {
    		users.get(User.getIndex(users, followerId)).removeFollow(followeeId);
    	}
    }
}

class User {
	Map<Integer, Integer> tweets = new HashMap<Integer, Integer>();
	ArrayList<User> follows;
	private int id;
	
	public User(int id) {
		this.id = id;
		this.follows = new ArrayList<User>();
	}
	
	public Map<Integer, Integer> getTweets() {
		return tweets;
	}

	public void setTweets(Map<Integer, Integer> tweets) {
		this.tweets = tweets;
	}
	
	public void addTweet(int date, int tweetID) {
		this.tweets.put(date, tweetID);
	}

	public ArrayList<User> getFollows() {
		return follows;
	}

	public void addFollow(User user) {
		this.follows.add(user);
	}
	
	public void removeFollow(int followID) {
		for (int i = 0; i < this.follows.size(); i++) {
			if (follows.get(i).getId() == followID)
				this.follows.remove(i);
		}
	}
	public void setFollows(ArrayList<User> follows) {
		this.follows = follows;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getIndex(ArrayList<User> users, int id) {
		if (users != null && users.size() > 0)
		{
			for(int i = 0; i < users.size(); i++) {
				if (users.get(i).getId() == id)
					return i;
			}
		}
			
		return -1;
	}
	
	public static boolean containUser(ArrayList<User> users, int id) {
		if (User.getIndex(users, id) < 0)
			return false;
		return true;
	}
}
