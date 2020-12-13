package com.techelevator.cardexample;

public class MainProgram
{

	public static void main(String[] args)
	{
		//creating an object template
		// type variable = new (allocates memory)
		String name = new String("Gregor");
		
		Card myCard = new Card ();
		myCard.setSuit("Spades");
		
		System.out.println(myCard.getSuit());
		
	

	}

}
