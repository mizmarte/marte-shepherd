package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTests 
{
	StringBits testGetBits = new StringBits();
//	GetBits("Hello") → "Hlo" 
//	GetBits("Hi") → "H" 
//	GetBits("Heeololeo") → "Hello"
//	
	@Test
	public void getBitsToTakeEveryOtherCharInAString_andShouldReturn_newStringWithOnlyThoseChars()
	{
		//arrange
		String input = "Heeololeo";
		
		String expected = "Hello";
		
		//act
		
		String actual = testGetBits.getBits(input);
		
		//assert
		Assert.assertEquals("Because the funtion takes every other character in a string(starting with first) and returns new string with only those characters",expected, actual);
	}
	
	@Test
	public void getBitsFunctionAndA2CharString_shouldReturn_onlyTheFirstLetter()
	{
		//arrange
		String input = "Hi";
		
		String expected = "H";
		
		//act
		
		String actual = testGetBits.getBits(input);
		
		//assert
		Assert.assertEquals("With a 2 character string, the function will return new string with only the first letter",expected, actual);
	}
	
	@Test
	public void getBitsFunctionAndA1CharString_shouldReturn_onlyThatLetter()
	{
		//arrange
		String input = "H";
		
		String expected = "H";
		
		//act
		
		String actual = testGetBits.getBits(input);
		
		//assert
		Assert.assertEquals("With a string containing only 1 character, the function will return new string with only that letter",expected, actual);
	}
	
}
