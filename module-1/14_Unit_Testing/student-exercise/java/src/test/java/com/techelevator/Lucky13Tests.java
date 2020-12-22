package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Tests 
{
	//GetLucky([0, 2, 4]) → true 
	//GetLucky([1, 2, 3]) → false 
	//GetLucky([1, 2, 4]) → false
	Lucky13 areYouReallyLucky = new Lucky13();                                                                  	
	@Test
	public void ifArrayHasA1Or3_itShouldReturnFalse()
	{
		//arrange
		
		int[] actual = {1,2,3};
		boolean expected = false;
		
		//act
		boolean actual1 = areYouReallyLucky.getLucky(actual);
		
		//assert
		Assert.assertEquals("Because numbers 1 and 3 are not lucky numbers",expected,actual1);
	}
	
	@Test
	public void ifArrayDoesNotHaveA1Or3_itShouldReturnTrue()
	{
		//arrange
		Lucky13 areYouReallyLucky = new Lucky13();
		int[] actual = {2,4,6,8,10,12,11,13};
		boolean expected = true;
		
		//act
		boolean actual1 = areYouReallyLucky.getLucky(actual);
		
		//assert
		Assert.assertEquals("Because there are no numbers 1 and 3 in this array",expected,actual1);
	}
}
