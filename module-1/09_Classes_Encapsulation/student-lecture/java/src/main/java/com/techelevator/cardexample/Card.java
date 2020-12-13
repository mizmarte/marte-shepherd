package com.techelevator.cardexample;

public class Card 
{
	//what does it know?
	// anything that it knows should ALWAYS be private
	private String suit;
	private String faceValue;
	private int value;
	private boolean isFaceUp;
	
	// getters return the value
	// that are stored in the private variables
	public String getSuit()
	{
		return suit;
	}
	
	//setters change/set the value
	//of the private variables
	public void setSuit(String newSuit)
	{
		suit = newSuit;

	}
	
	public String getFaceValue()
	{
		return faceValue;
	}
	
}
