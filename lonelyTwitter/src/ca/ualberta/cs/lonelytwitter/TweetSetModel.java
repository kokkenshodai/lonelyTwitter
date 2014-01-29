package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TweetSetModel
{
	int count  = 0;
	ArrayList<LonelyTweetModel> tweets = new ArrayList<LonelyTweetModel>();
	
	public int countTweets()
	{
		return count;
	}

	public void addTweet(LonelyTweetModel newTweet) throws IllegalArgumentException
	{	
		for(int n = 0; n < tweets.size(); n++)
		{
			if(tweets.get(n).equals(newTweet)) throw new IllegalArgumentException("cannot add same tweet twice");
		}
		
		count++;
		tweets.add(newTweet);
	}

	public LonelyTweetModel[] getTweets()
	{

		return tweets.toArray(new LonelyTweetModel[tweets.size()]);
	}

}
