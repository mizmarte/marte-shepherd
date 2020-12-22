package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTests 

{
	AnimalGroupName isItThere = new AnimalGroupName();	
	//GetHerd("giraffe") → "Tower"
//    * GetHerd("") -> "unknown"
//    * GetHerd("walrus") -> "unknown"
//    * GetHerd("Rhino") -> "Crash"
//    * GetHerd("rhino") -> "Crash"
//    * GetHerd("elephants") -> "unknown"
	
	@Test
	public void map_shouldReturnUnknown_whenAnimaListedIsNotOnMap()
	{
		//arrange- 
		
		String userInput = "elephants";
		String expected = 	"unknown";
		
		//act - if the animal name is not listed on map return unknown
//				if no animal name is listed return unknown
		String actual = isItThere.getHerd(userInput);
		
		//assert - Because animal name listed returns AnimalGroupName
		Assert.assertEquals("Because animal name not listed on map returns unknown.",expected,actual);
		
	}
	
	@Test
	public void map_shouldReturnAnimalGroupName_whenAnimalListedOnMapInLowerCase()
	{
		//arrange- 
				
				String userInput = "rhino";
				String expected = 	"Crash";
				
				//act - if the animal name listed in lowercase on map returns AnimalGroupName
//						
				String actual = isItThere.getHerd(userInput);
				
				//assert - Because animal name listed returns AnimalGroupName
				Assert.assertEquals("Because animal name listed in lowercase returns AnimalGroupName.",expected,actual);
				
		
	}
	
	@Test
	public void map_shouldReturnAnimalGroupName_whenAnimalListedContainsCaps()
	{
		//arrange- 
				
				String userInput = "RHINO";
				String expected = 	"Crash";
					
				//act - if the animal name listed on map contains caps - returns AnimalGroupName
//						
				String actual = isItThere.getHerd(userInput);
				
				//assert
				Assert.assertEquals("Because animal name listed (on map) contains caps returns AnimalGroupName.",expected,actual);
				
		
	}
	
	@Test
	public void map_shouldUnknown_whenNoAnimalIsListedAtAll()
	{
		//arrange- 
				
				String userInput = "";
				String expected = 	"unknown";	
				
				//act - if there is no animal name listed returns unknown
//						
				String actual = isItThere.getHerd(userInput);
				
				//assert 
				Assert.assertEquals("Because no animal name listed returns unknown.",expected,actual);
				
		
	}
	
}
