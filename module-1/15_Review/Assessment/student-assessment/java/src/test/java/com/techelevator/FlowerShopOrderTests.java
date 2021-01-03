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
	public void basicBouquetIsTheCheapest_itShouldReturn_Subtotal1999() 
	{
		FlowerShopOrder howMuchAreYourFlowers = new FlowerShopOrder("basic", 0);
		{
			//arrange
			howMuchAreYourFlowers.getNumberOfRoses();
			double expectedCost = 19.99;
			
			
			//act
			double actualCost = howMuchAreYourFlowers.subtotal();
			double delta = Math.abs(expectedCost - actualCost);
			//assert
			Assert.assertEquals("Because bouquets with no roses are the cheapest",expectedCost, actualCost,delta);
		}
	}

}
