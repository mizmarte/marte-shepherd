package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTests 
{
	NonStart testPartialString = new NonStart();
	
//	GetPartialString("Hello", "There") → "ellohere"
//    GetPartialString("java", "code") → "avaode"
//    GetPartialString("shotl", "java") → "hotlava"
	
	@Test
	public void getPartialString_shouldRemoveTheFirstLetterFromBothWordsAndJoinTheRestOfTheLettersMaking1Word()
	{
		//arrange
		String a = "Hello";
		String b = "There";
		String expected = "ellohere";
		
		//act
		String actual = testPartialString.getPartialString(a, b);
		
		//assert
		Assert.assertEquals("Because the function should remove the first letter of each string and join the rest of the letters together as 1 word", expected, actual);
	}
	
	@Test
	public void if1StringisLength1getPartialString_shouldReturnOnlyTheLongerWordWithTheFirstLetterRemoved()
	{
		//arrange
		String a = "Hello";
		String b = "T";
		String expected = "ello";
		
		//act
		String actual = testPartialString.getPartialString(a, b);
		
		//assert
		Assert.assertEquals("If one of the strings is length = 1, the function should remove the first letter from the longer string, and return the longer string only", expected, actual);
	}
}
