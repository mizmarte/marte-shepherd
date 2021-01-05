package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

//Basic,0
//Elite,12
//Elegant,24
//Apology,48
//Nuptial,18
//Bereavement,12

public class FlowerShopOrderTests 
{
	@Test
	public void constructor_createsCorrectBouquetName()
	{

//		arrange
		String expected = "standard";
//		act
		FlowerShopOrder order = new FlowerShopOrder("standard",0);
		String actual = order.getBouquetType();
		
//		assert
		Assert.assertEquals(expected, actual);
		
	}
	@Test
	public void subtotal_calculates_correctPice()
	{
		FlowerShopOrder order2 = new FlowerShopOrder ("huge", 15);
		double expected = 64.84;
		double actual = order2.getSubtotal();
		double delta = expected - actual;
		Assert.assertEquals(expected, actual, delta);
	}
	
	
	
	@Test
	public void basicBouquetIsTheCheapest_itShouldReturn_Subtotal1999() 
	{
		FlowerShopOrder howMuchAreYourFlowers = new FlowerShopOrder("basic", 0);
		{
			//arrange
			howMuchAreYourFlowers.getNumberOfRoses();
			double expectedCost = 19.99;
			
			
			//act
			double actualCost = howMuchAreYourFlowers.getSubtotal();
			double delta = Math.abs(expectedCost - actualCost);
			//assert
			Assert.assertEquals("Because bouquets with no roses are the cheapest",expectedCost, actualCost,delta);
		}
	}

}
