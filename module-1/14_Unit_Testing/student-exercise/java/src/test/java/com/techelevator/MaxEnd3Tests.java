package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Tests 
{
	MaxEnd3 isItTheBiggest = new MaxEnd3();
	@Test
	public void isTheFirstElementTheLargest_ShouldReturnAllElementsEqualToFirstElement()
	{
		//arrange
		
		
		int[] userInput = new int[] {11,5,9};
		int[] expected = new int[] {11,11,11};
		//act
		
		int[] actual = isItTheBiggest.makeArray(userInput);
		
		//assert
		Assert.assertArrayEquals("Because the first number is the largest number, the array will now list the largest number 3 times",expected, actual);
	}
	
	@Test
	public void isTheLastElementTheLargest_ShouldReturnAllElementsEqualToLastElement()
	{
		//arrange
		
		
				int[] userInput = new int[] {11,5,20};
				int[] expected = new int[] {20,20,20};
				//act
				
				int[] actual = isItTheBiggest.makeArray(userInput);
				
				//assert
				Assert.assertArrayEquals("Because the last number is the largest number, the array will now list the largest number 3 times",expected, actual);
	}
	
	
}
