package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MovieRentalTests 
{
//	Godfather,DVD,true
//	The Room,VHS,false
//	Fast and Furious,Blu-ray,false
//	1984,Blu-ray,true
//	Soylent Green,DVD,true
//	Star Trek 4: The Voyage Home,VHS,false
//	Star Wars: The Phantom Menace,Blu-ray,false
	
	@Test
	public void rentalOfVHSnotPremiumShouldReturnOnly99Cents()
	{
		MovieRental areYallGettingChargedEnough = new MovieRental("Star Trek","VHS",false);	
		//arrange
		String format = "VHS";
		boolean isPremium = false;
		double expectedCost = 0.99;
		
		
		//act
		double actual = areYallGettingChargedEnough.rentalPrice(areYallGettingChargedEnough.getFormat(), areYallGettingChargedEnough.isPremium());
		double delta = Math.abs(expectedCost - actual);
		
		//assert
		Assert.assertEquals("Because VHS non-Premium rentals are 0.99", expectedCost, actual, delta);
	}
	
	@Test
	public void rentalOfVHSPremiumShouldReturn199()
	{
		MovieRental areYallGettingChargedEnough = new MovieRental("Color Purple", "VHS", true);
		//arrange
		String movieFormat = "VHS";
		boolean premiumFlick = true;
		double expectedCost = 1.99;
		
		
		//act
		double actual = areYallGettingChargedEnough.rentalPrice(movieFormat, premiumFlick);
		double delta = Math.abs(expectedCost - actual);
		
		//assert
		Assert.assertEquals("Because VHS Premium rentals are 1.99", expectedCost, actual, delta);
	}
	@Test
	public void rentalOfDVDnotPremiumShouldReturn199()
	{
		MovieRental areYallGettingChargedEnough = new MovieRental("Fame", "DVD", false);
		//arrange
		String movieFormat = "DVD";
		boolean premiumFlick = false;
		double expectedCost = 1.99;
		
		
		//act
		double actual = areYallGettingChargedEnough.rentalPrice(movieFormat, premiumFlick);
		double delta = Math.abs(expectedCost - actual);
		
		//assert
		Assert.assertEquals("Because DVD non-Premium rentals are 1.99", expectedCost, actual, delta);
	}
	
	@Test
	public void rentalOfDVDPremiumShouldReturn299()
	{
		MovieRental areYallGettingChargedEnough = new MovieRental("Tenet", "DVD",true);
		//arrange
		String movieFormat = "DVD";
		boolean premiumFlick = true;
		double expectedCost = 2.99;
		
		
		//act
		double actual = areYallGettingChargedEnough.rentalPrice(movieFormat, premiumFlick);
		double delta = Math.abs(expectedCost - actual);
		
		//assert
		Assert.assertEquals("Because DVD Premium rentals are 2.99", expectedCost, actual, delta);
	}
	
	@Test
	public void rentalOfBluRaynotPremiumShouldReturn299()
	{
		MovieRental areYallGettingChargedEnough = new MovieRental("Annabelle", "BluRay",false);
		//arrange
		String movieFormat = "BluRay";
		boolean premiumFlick = false;
		double expectedCost = 2.99;
		
		
		//act
		double actual = areYallGettingChargedEnough.rentalPrice(movieFormat, premiumFlick);
		double delta = Math.abs(expectedCost - actual);
		
		//assert
		Assert.assertEquals("Because BluRay non-Premium rentals are 2.99", expectedCost, actual, delta);
	}
	
	@Test
	public void rentalOfBluRayPremiumShouldReturn399()
	{
		MovieRental areYallGettingChargedEnough = new MovieRental("Snow Dogs", "Blu-Ray",true);
		//arrange
		String movieFormat = "Blu-Ray";
		boolean premiumFlick = true;
		double expectedCost = 3.99;
		
		
		//act
		double actual = areYallGettingChargedEnough.rentalPrice(movieFormat, premiumFlick);
		double delta = Math.abs(expectedCost - actual);
		
		//assert
		Assert.assertEquals("Because Blu-Ray Premium rentals are 3.99", expectedCost, actual, delta);
	}
}
