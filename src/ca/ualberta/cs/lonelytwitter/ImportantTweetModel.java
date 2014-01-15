package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class ImportantTweetModel extends LonelyTweetModel implements HasPriority
{

	public ImportantTweetModel()
	{
		super();
	}

	public ImportantTweetModel(String text, Date timestamp)
	{
		super(text, timestamp);
	}

	public ImportantTweetModel(String text)
	{
		super(text);
	}

	@Override
	public void setText(String text)

	{
		this.text = text;
	}
	
	public Mode Mode()
	{
		return Mode.Important;
	}
	
}
