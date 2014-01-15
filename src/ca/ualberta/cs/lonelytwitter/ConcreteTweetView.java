package ca.ualberta.cs.lonelytwitter;


public class ConcreteTweetView implements TweetView
{

	public String formatTweet(LonelyTweetModel lt)
	{
		return lt.getTimestamp().toString() + " | " + lt.getText();
	}

}
