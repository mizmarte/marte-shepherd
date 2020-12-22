package com.techelevator;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.booleanThat;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTests 

{
	DateFashion doWeBothLookGoodEnough = new DateFashion();
	@Test
	public void weAreBothLookingGood_soItShouldReturn_weAreGettingIn()
	{	
//		dateFashion(5, 10) → 2
//	    dateFashion(5, 2) → 0
//	    dateFashion(5, 5) → 1
	   
		//arrange
		
		int me = 5;
		int myBoo = 10;
		int expectedGetTable = 2;


		//act
		int actual = doWeBothLookGoodEnough.getATable(me, myBoo);

		
		//assert
		Assert.assertEquals("Because we both look good enough to get a table",expectedGetTable, actual);
	}
	
	@Test
	public void iLookAverageAndHeIsNotVeryStylish_soItShouldReturn_weAreNotGettingIn()
	{	
//		dateFashion(5, 10) → 2
//	    dateFashion(5, 2) → 0
//	    dateFashion(5, 5) → 1
	   
		//arrange
		
		int me = 5;
		int myBoo = 2;
		int expectedGetTable = 0;


		//act
		int actual = doWeBothLookGoodEnough.getATable(me, myBoo);

		
		//assert
		Assert.assertEquals("Because looking average and not stylish WON'T gets us a table",expectedGetTable, actual);
	}
	
	@Test
	public void weBothAreLookingAverage_soItShouldReturn_weMayGetThatTable()
	{	
//		dateFashion(5, 10) → 2
//	    dateFashion(5, 2) → 0
//	    dateFashion(5, 5) → 1
	   
		//arrange
		
		int me = 5;
		int myBoo = 5;
		int expectedGetTable = 1;


		//act
		int actual = doWeBothLookGoodEnough.getATable(me, myBoo);

		
		//assert
		Assert.assertEquals("Because both looking average only gets us a 'maybe' rating for a table",expectedGetTable, actual);
	}
	
	
	
}
