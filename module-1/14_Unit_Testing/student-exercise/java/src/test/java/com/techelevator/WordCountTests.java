package com.techelevator;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

//* getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
//* getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
//* getCount([]) → {}
//* getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}


public class WordCountTests 
{
	WordCount testDictionary = new WordCount();
	@Test
	public void doesWordCountFunction_Return_theCorrectNumberOfOccurencesOfAString()
	{
		//arrange
		
		Map<String, Integer> testOutput = new HashMap<>();
		String testWord = new String();
		String [] testWords =  {"ba", "ba", "black", "sheep"};
	
		Map<String, Integer> expected = new HashMap<>();
		expected.put("ba", 2);
		expected.put("black",1);
		expected.put("sheep",1);

		//act
		Map<String, Integer> finalCount = testDictionary.getCount(testWords);
		
		//assert
		Assert.assertEquals("Because this function returns how many times a string appears in an array",expected, finalCount);
	}
	
	@Test
	public void ifStringArrayValueIsNull_doesIt_Return_theCorrectNumberOfOccurencesOfAString()
	{
		//arrange
		
		Map<String, Integer> testOutput = new HashMap<>();
		String testWord = new String();
		String [] testWords =  null;
	
		Map<String, Integer> expected = new HashMap<>();
	

		//act
		Map<String, Integer> finalCount = testDictionary.getCount(testWords);
		
		//assert
		Assert.assertEquals("Because this function should return an empty map if array value is null",expected, finalCount);
	}
	@Test
	public void ifStringArraysContainsOnly1Letter_doesIt_Return_theCorrectNumberOfOccurencesOfAString()
	{
		//arrange
		
		Map<String, Integer> testOutput = new HashMap<>();
		String testWord = new String();
		String [] testWords =  {"a","b","b","d","c","d","c","e","f"};
	
		Map<String, Integer> expected = new HashMap<>();
		expected.put("a", 1);
		expected.put("b",2);
		expected.put("c",2);
		expected.put("d",2);
		expected.put("e",1);
		expected.put("f",1);
		
		
		//act
		Map<String, Integer> finalCount = testDictionary.getCount(testWords);
		
		//assert
		Assert.assertEquals("Because this function should return the correct word count if array values are only 1 letter each",expected, finalCount);
	}
	
}
