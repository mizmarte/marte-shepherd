package com.techelevator;

public class FruitTree 
{

	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	public String getTypeOfFruit()
	{
		return typeOfFruit;
	}
	public int getPiecesOfFruitLeft()
	{
		return piecesOfFruitLeft;
	}
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit)
	{
		piecesOfFruitLeft = startingPiecesOfFruit;
		
		this.typeOfFruit = typeOfFruit;
		
	}
	public boolean pickFruit (int numberOfPiecesToRemove) 
	{
		if (piecesOfFruitLeft >= numberOfPiecesToRemove)
		{
			piecesOfFruitLeft -= numberOfPiecesToRemove;
			
			return true;
		}
		
		return false;
	}
}