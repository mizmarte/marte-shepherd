package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Tests 
{
//	less20(18) → true
//    less20(19) → true
//    less20(20) → false
	Less20 isThisActually1Or2LessThanAMultipleOf20 = new Less20();
	@Test
	public void oneOrTwoLessThanMultipleOf20_shouldReturnTrue()
	{
		//arrange
		
		int number = 18;
		boolean expected = true;
		
		//act
		boolean actual = isThisActually1Or2LessThanAMultipleOf20.isLessThanMultipleOf20(number);
		
		//assert
		Assert.assertEquals("Because this number is 1 or 2 less than a multiple of 20",expected, actual);
	}
	
	@Test
	public void moreThanOneOrTwoLessThanMultipleOf20_shouldReturnFalse()
	{
		//arrange
		int number = 16;
		boolean expected = false;
		
		//act
		boolean actual = isThisActually1Or2LessThanAMultipleOf20.isLessThanMultipleOf20(number);
		
		//assert
		Assert.assertEquals("Because this number is more than 1 or 2 less than a multiple of 20",expected, actual);
	}
	
}
