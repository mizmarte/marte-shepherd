package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTests 
{
	FrontTimes genTestString = new FrontTimes();
	@Test
	public void doesThisReturnTheFirst3CharactersInTheString()
	{
//		frontTimes("Chocolate", 2) →"ChoCho" 
//		frontTimes("Chocolate", 3) → "ChoChoCho" 
//		frontTimes("Abc", 3) → "AbcAbcAbc"
		
		//arrange
		
		String actual = "Luxury";
		int actual2 = 1;
		String expected = "Lux";
		
		//act
		String actResult = genTestString.generateString(actual, actual2);
	
		//assert
		Assert.assertEquals("Because this returns only the first 3 letters of the string",expected, actResult);
	}
	
	@Test
	public void doesThisReturnTheFirst3CharactersInTheStringNTimes()
	{
//		frontTimes("Chocolate", 2) →"ChoCho" 
//		frontTimes("Chocolate", 3) → "ChoChoCho" 
//		frontTimes("Abc", 3) → "AbcAbcAbc"
		
		//arrange
		FrontTimes genTestString = new FrontTimes();
		String actual = "Luxury";
		int actual2 = 4;
		String expected = "LuxLuxLuxLux";
		
		//act
		String actResult = genTestString.generateString(actual, actual2);
	
		//assert
		Assert.assertEquals("Because this returns the first 3 letters of the string n-times",expected, actResult);
	}
	
}
