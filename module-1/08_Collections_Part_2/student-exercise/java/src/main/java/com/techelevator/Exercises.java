package com.techelevator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) 
	{
		
		
		if(animalName == null || animalName == "")
		{
			return "unknown";
		}
		
		Map<String, String> animalGroups = new HashMap<String, String>();
		
		String animalNoCaps = animalName.toLowerCase();
		
		animalGroups.put("rhino", "Crash");
		animalGroups.put("giraffe", "Tower");
		animalGroups.put("elephant", "Herd");
		animalGroups.put("lion", "Pride");
		animalGroups.put("crow", "Murder");
		animalGroups.put("pigeon", "Kit");
		animalGroups.put("flamingo", "Pat");
		animalGroups.put("deer", "Herd");
		animalGroups.put("dog", "Pack");
		animalGroups.put("crocodile", "Float");
		
		if(animalGroups.get(animalNoCaps) == null)
		{
			return "unknown";
		}
		
		return animalGroups.get(animalNoCaps);
		
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) 
	{
		if (itemNumber == null || itemNumber == "")
		{
			return 0.00;
		}
		
		Map<String, Double> isItOnSale = new HashMap<String, Double>();
		
		//create a map
		isItOnSale.put("kitchen4001",  0.20);
		isItOnSale.put("garage1070",  0.15);
		isItOnSale.put("livingroom",  0.10);
		isItOnSale.put("kitchen6073",  0.40);
		isItOnSale.put("bedroom3434",  0.60);
		isItOnSale.put("bath0073",  0.15);
		
		//no for loop 
		//use if before going through map
		String itemNumberNoCaps = itemNumber.toLowerCase();
		
		if (isItOnSale.get(itemNumberNoCaps) == null)
		{
			return 0.00;
		}
		
		
		return isItOnSale.get(itemNumberNoCaps);	
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) 
	
	{
		int petersMoney = peterPaul.get("Peter");
		int paulsMoney = peterPaul.get("Paul");
		
		boolean paulNeedsMoney = paulsMoney < 1000;
		
		if (paulNeedsMoney)
		{
			int halfPeter = petersMoney/2;
			paulsMoney += halfPeter;
			petersMoney -= halfPeter;
			
			peterPaul.put("Peter", petersMoney);
			peterPaul.put("Paul", paulsMoney);
		}
		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) 
	{

		//define variables for peter's money and paul's money
		Integer petersMoney = peterPaul.get("Peter");
		Integer paulsMoney = peterPaul.get("Paul");
		//if peter money > 5000 AND pauls money >10000 then new peterpaul = (peter+paul)*0.25
		if (petersMoney >= 5000 && paulsMoney >= 10000)
		{
			Integer combinedPartnershipCash = (petersMoney + paulsMoney)/4;
			Integer petersNewStash = petersMoney - (petersMoney/4);
			Integer paulsNewStash = paulsMoney - (paulsMoney/4);
			peterPaul.put("Peter" , petersNewStash);
			peterPaul.put("Paul", paulsNewStash);
			peterPaul.put("PeterPaulPartnership", combinedPartnershipCash);
		}
		//once money goes to partnership need to express remaining balance for both peter and paul
	return peterPaul;
		
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) 
	{
		//create a map
		Map<String, String> beginAndEnd = new HashMap<String, String>();
		//going through an array, so a for each statement is needed
		
		for (String beginKey: words)
			//loop through array and assign first letter of string as key and last letter of string as value
			//since it's not a true false or if something exists, if statement is not necessary
			//how to express first letter of word in each array element
		{
			String firstKey = beginKey.substring(0,1);
			String lastValue = beginKey.substring(beginKey.length() - 1);
	
			beginAndEnd.put(firstKey, lastValue);
//			//how to express last letter of word in each array element
		}	
			
		//define key value for array
		//define a value value for array
		
		return beginAndEnd;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) 
	{	//create hashmap to return
		Map<String, Integer> outMap = new HashMap<String, Integer>();
				
		//create a count variable for when the value is in the hashmap
		Integer count = 0;
		
		//loop through the array and determine if string exists in the hashmap
		//if it doesn't add it set the count to 1.  if it does exist count 
		
		for (String word: words)
		{
			if (!outMap.containsKey(word))
			{
				outMap.put(word, 1);
			}
			else
			{
				count = outMap.get(word) + 1;
				
				outMap.put(word, count);
			}
		
		}
		return outMap;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) 
	{
		//create a hashmap
		Map<Integer, Integer> keyCount = new HashMap<Integer, Integer>();
		
		//need a variable for counting
		Integer count = 0;
		//will need a for loop to go through the array of int value
		for (Integer keyInt: ints)
		{
			if (!keyCount.containsKey(keyInt))
			{
				keyCount.put(keyInt, 1);
			}
			else
			{
				count = keyCount.get(keyInt) + 1;
				keyCount.put(keyInt, count);
			}
		}
		//variable for the key of map
		
		return keyCount;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) 
	{
		Map<String, Integer> stringCount = new HashMap();
		
		Map<String, Boolean> map = new HashMap();
		
		int count = 0;
		
		for(String key: words ) 
		{
		    if(stringCount.containsKey(key)) 
		    
		    {
		      count = stringCount.get(key);
		      
		      count++;
		      
		      stringCount.put(key, count);
		    } 
		    else 
		    {
		      stringCount.put(key, 1);
		    }
		    map.put(key, stringCount.get(key) >= 2);
		  }
		  return map;
		
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) 
	{
		Map<String, Integer> combinedInventory = new HashMap<String, Integer>(mainWarehouse);
		//define some variable for keys and values of both maps
		
		//need for loop to go through all of the items
		//for (String placeHolder: need to iterate through the remote keys )
		//if remotewarehouse's key is not equal to main warehouse's key, then add that kv pair to mainwarehouse map
		remoteWarehouse.forEach((key, value) ->
		{
			if (combinedInventory.containsKey(key))
			{
				combinedInventory.put(key, combinedInventory.get(key) + value);
			}
			else {
				combinedInventory.put(key, value);
				
			}
		});	
			
		return combinedInventory;

	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public int last2(String str) 
	
	{
		int count = 0;
		
		for(int i = 0; i < str.length() - 2; i++)
		{
			if(str.substring(i, i + 2).contentEquals(str.substring(str.length() - 2)))
				{
					count++;
				}
		}
		return count;
	}
//**********function from day 6 exercises******************************	
	
	public Map<String, Integer> last2Revisited(String[] words)
	{
		//create a map for return
		Map<String, Integer> last2Again = new HashMap<String, Integer>();
		
		for (String lastTwo: words)
		{
			last2Again.put(lastTwo, last2(lastTwo));
		}	
		
		return last2Again;
	}

}
