package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTests 
{
//	   IsItTheSame([1, 2, 3]) → false
//	   IsItTheSame([1, 2, 3, 1]) → true
//	   IsItTheSame([1, 2, 1]) → true

	SameFirstLast testIsItTheSame = new SameFirstLast();
	
	@Test
	public void ifFirstAndLastElementAreEqual_functionShouldReturn_True()
	{
		//arrange
		int nums[] = {3,2,3};
		boolean expected = true;
		
		//act
		
		boolean actual = testIsItTheSame.isItTheSame(nums);
		
		//assert
		Assert.assertEquals("Because function is true if first and last elements are equal",expected, actual);
	}
	
	@Test
	public void ifFirstAndLastElementAreNotEqual_functionShouldReturn_False()
	{
		//arrange
		int nums[] = {1,2,3};
		boolean expected = false;
		
		//act
		
		boolean actual = testIsItTheSame.isItTheSame(nums);
		
		//assert
		Assert.assertEquals("Because function is false if first and last elements are not equal",expected, actual);
	}
	
	@Test
	public void ifArrayIsEmpty_functionShouldReturn_False()
	{
		//arrange
		int nums[] = {};
		boolean expected = false;
		
		//act
		
		boolean actual = testIsItTheSame.isItTheSame(nums);
		
		//assert
		Assert.assertEquals("Because function is false if array is empty",expected, actual);
	}
	
	@Test
	public void ifArrayHasOnly1Element_functionShouldReturn_True()
	{
		//arrange
		int nums[] = {2};
		boolean expected = true;
		
		//act
		
		boolean actual = testIsItTheSame.isItTheSame(nums);
		
		//assert
		Assert.assertEquals("Because function is true if array has only 1 element",expected, actual);
	}
	
}
