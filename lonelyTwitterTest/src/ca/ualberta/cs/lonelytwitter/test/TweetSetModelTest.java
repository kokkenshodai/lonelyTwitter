package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetSetModel;
import android.test.ActivityInstrumentationTestCase2;


public class TweetSetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{

	public TweetSetModelTest()
	{
		super(LonelyTwitterActivity.class);
	}
	
	public void testCount(){
		TweetSetModel tweets = new TweetSetModel();
		
		assertEquals("tweet set should start empty", 0, tweets.countTweets());
		
		tweets.addTweet(new NormalTweetModel("test"));
		
		assertEquals("tweet set should now be 1",1, tweets.countTweets());
	}
	
	public void testEquals(){
		NormalTweetModel tweet1 = new NormalTweetModel("test1");
		ImportantTweetModel tweet2 = new ImportantTweetModel("test1");
		
		assertEquals("tweet should equal itself", true, tweet1.equals(tweet1));
		assertEquals("tweet should equal itself", true, tweet2.equals(tweet2));
		assertEquals("tweet should not equal another", false, tweet1.equals(tweet2));
		assertEquals("tweet should not equal another", false, tweet2.equals(tweet1));
		
		ImportantTweetModel tweet3 = new ImportantTweetModel("test2");
		
		assertEquals("tweet should not equal another", false, tweet3.equals(tweet2));
		assertEquals("tweet should not equal another", false, tweet2.equals(tweet3));
	}
	
	public void testGet(){
		TweetSetModel tweets = new TweetSetModel();
		ArrayList<LonelyTweetModel> testTweetList = new ArrayList<LonelyTweetModel>();
		
		//assertEquals("empty test has length 0", 0, testTweetList.toArray(new LonelyTweetModel[testTweetList.size()]).length);
		assertEquals("empty tweet set returns empty array", true, arrayEquals(testTweetList.toArray(new LonelyTweetModel[testTweetList.size()]), tweets.getTweets()));
		
		NormalTweetModel tweet1 = new NormalTweetModel("test1");
		tweets.addTweet(tweet1);
		testTweetList.add(tweet1);
		
		assertEquals("tweet set equals test array", true, arrayEquals(testTweetList.toArray(new LonelyTweetModel[testTweetList.size()]), tweets.getTweets()));
		
		TweetSetModel tweets2 = new TweetSetModel();
		ImportantTweetModel tweet2 = new ImportantTweetModel("test1", tweet1.getTimestamp());
		tweets2.addTweet(tweet2);
		
		assertEquals("normal does not equal important", false, arrayEquals(testTweetList.toArray(new LonelyTweetModel[testTweetList.size()]), tweets2.getTweets()));
		
	}
	
	public void testAddException()
	{
		TweetSetModel tweets = new TweetSetModel();
		
		NormalTweetModel tweet1 = new NormalTweetModel("test1");
		
		try
		{
			tweets.addTweet(tweet1);
			tweets.addTweet(tweet1);
			
			fail("should not be able to add same tweet twice");
		}
		catch(IllegalArgumentException ex)
		{
			
		}
	}
	
	private boolean arrayEquals(LonelyTweetModel[] array1, LonelyTweetModel[] array2)
	{
		
		if(array1 == null)
		{
			if(array2 == null)
				return true;
			else
				return false;
		}
		if(array1.length != array2.length) return false;
		
		for(int n =0; n < array1.length; n++)
		{
			if(!array1[n].equals(array2[n]))return false;
		}
		
		return true;
	}

}
