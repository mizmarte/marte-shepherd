package com.techelevator;

import org.junit.Test;

import junit.framework.Assert;

public class DemoTests 
{
	@Test
	public void sample_test() 
	{
		//arrange
		//setup variable for THIS test
		int numerator = 5;
		int denominator = 2;
		
		int expected = 3;
		
		
		
		//act - the ONE action that i'm testing
		int answer = numerator / denominator;
		
		
		
		
		//assert 
		// -- did it work
		//TEST ONLY 1 THING - 1 assert statement
		Assert.assertEquals("Because integer division truncates the remainder", expected, answer);
	
	}
	
	
}
