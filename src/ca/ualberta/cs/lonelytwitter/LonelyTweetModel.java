package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public abstract class LonelyTweetModel
{
	protected String text;
	protected Date timestamp;
	
	public String getText()
	{
	
		return text;
	}
	
	public abstract void setText(String text);

	
	public Date getTimestamp()
	{
	
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp)

	{
	
		this.timestamp = timestamp;
	}
	

	public LonelyTweetModel(String text, Date timestamp)
	{

		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public LonelyTweetModel(String text)
	{

		super();
		this.text = text;
		this.timestamp = new Date();
	}
	
	public LonelyTweetModel()
	{

		super();
		this.text = "";
		this.timestamp = new Date();
	}
	
	@Override
	public String toString()
	{
		return timestamp.toString() + " | " + text;
	}
	
}
