package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTests 

{
	CigarParty party = new CigarParty();
	@Test
	public void haveParty_shouldReturnFalse_whenFewerThan30CigarsOnWeekend()
	{
		//arrange
		int numberOfCigars = 30;
		boolean isWeekend = false;
		
		//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		//assert
		Assert.assertFalse("Because parties with < 40 cigars suck ", actual);
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan30CigarsOnWeekend()
	{
		//arrange
		int numberOfCigars = 50;
		boolean isWeekend = false;
		
		//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		//assert
		Assert.assertTrue("Because you need more squirrels for cigar fun", actual);
		
		
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan70CigarsOnWeekend()
	{
		//arrange
		
		int numberOfCigars = 71;
		boolean isWeekend = true;
		
		//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		//assert
		Assert.assertTrue("Because you need more squirrels for cigar fun", actual);
		
	}
	
	
	@Test
	public void haveParty_shouldReturnFalse_whenFewerThan30CigarsOnWeekday() 
	{ 	
		//arrange
	
		int numberOfCigars = 29;
		boolean isWeekend = false;
	
	//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
	
	//assert
		Assert.assertFalse("Because parties with < 40 cigars suck", actual);
	
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan30CigarsOnWeekday() 
	{ 	
		//arrange

		int numberOfCigars = 50;
		boolean isWeekend = true;
	
	//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
	
	
	//assert
		Assert.assertTrue("Because you need more squirrels for cigar fun", actual);
	
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan70CigarsOnWeekday() 
	{ 
		//arrange
		
		int numberOfCigars = 70;
		boolean isWeekend = true;
		
		//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		//assert
		Assert.assertTrue("Because you need more squirrels for cigar fun", actual);
			
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan69CigarsOnWeekend()
	{
		//arrange
		
		int numberOfCigars = 69;
		boolean isWeekend = true;
		
		//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		//assert
		Assert.assertTrue("Because you need more squirrels for cigar fun", actual);
		
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan71CigarsOnWeekend()
	{
		//arrange
		
		int numberOfCigars = 71;
		boolean isWeekend = true;
		
		//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		//assert
		Assert.assertTrue("Because you need more squirrels for cigar fun", actual);
		
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan49CigarsOnWeekend()
	{
		//arrange
		int numberOfCigars = 49;
		boolean isWeekend = true;
		
		//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		//assert
		Assert.assertTrue("Because you need more squirrels for cigar fun", actual);
		
		
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan51CigarsOnWeekend()
	{
		//arrange
		int numberOfCigars = 51;
		boolean isWeekend = true;
		
		//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		//assert
		Assert.assertTrue("Because you need more squirrels for cigar fun", actual);
		
		
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan31CigarsOnWeekday() 
	{ 	
		//arrange

		int numberOfCigars = 31;
		boolean isWeekend = false;
	
	//act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
	
	
	//assert
		Assert.assertFalse("Because you need more squirrels for cigar fun", actual);
	
	}
	
}
	
	
	
	
	
	
	
	

