package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class TweetListController
{
	private static TweetListModel model = null;
	
	public TweetListController(){
		super();
		if(model == null)
		{
			model = new TweetListModel();
		}
	}
	
	public void AddTweet(Mode mode, String text) throws IllegalArgumentException
	{
		switch(mode)
		{
			case Normal:
				LonelyTweetModel lt = new NormalTweetModel(text);
				model.getList().add(lt);
				break;
			case Important:
				lt = new ImportantTweetModel(text);
				model.getList().add(lt);
				break;
				
			default:
				throw new IllegalArgumentException("Unsupported Tweet Mode");
		}
		
	}
	
	public void AddTweet(Mode mode, String text, Date date)
	{
		switch(mode)
		{
			case Normal:
				LonelyTweetModel lt = new NormalTweetModel(text, date);
				model.getList().add(lt);
				break;
			case Important:
				lt = new ImportantTweetModel(text, date);
				model.getList().add(lt);
				break;
				
			default:
				throw new IllegalArgumentException("Unsupported Tweet Mode");
		}
	}
	
	public void AddTweet(Mode mode)
	{
		switch(mode)
		{
			case Normal:
				LonelyTweetModel lt = new NormalTweetModel();
				model.getList().add(lt);
				break;
			case Important:
				lt = new ImportantTweetModel();
				model.getList().add(lt);
				break;
				
			default:
				throw new IllegalArgumentException("Unsupported Tweet Mode");
		}
	}
}
