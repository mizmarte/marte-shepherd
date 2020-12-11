package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<Integer, String> students = new HashMap<Integer, String>();
		
		students.put(1, "Bugs Bunny");
		
		// creates a map with <K,V> <String, String>
		Map<String, String> dailySpecials = new HashMap<String, String>();
		
		dailySpecials.put("Monday", "Waffles");
		dailySpecials.put("Tuesday", "Pancakes");
		dailySpecials.put("Wednesday", "French Toast");
		dailySpecials.put("Thursday", "Eggs and Sausage");
		dailySpecials.put("Friday", "Oatmeal");
		dailySpecials.put("Saturday", "Grits");
		dailySpecials.put("Sunday", "Liver");
		
		String tuesdaySpecial = dailySpecials.get("Tuesday");
		System.out.println(tuesdaySpecial);
		
		String mondaySpecial = dailySpecials.get("Monday");
		System.out.println("Monday: " + mondaySpecial);
		
		System.out.println("####################");
		System.out.println("        Keys in Map");
		System.out.println("####################");
		System.out.println();
		
		//the keys of a map are a set
		//can use a keySet function to get all keys
		Set<String> keys = dailySpecials.keySet();
		
		for(String key: keys)
			
		{
			String special = dailySpecials.get(key);
			System.out.println(key + " " + special);
		}
		
		
		System.out.println();
		System.out.println();
		
		// option 2
		// -- loop throug eac ROW (Key Value Pair)
		// -- get the key and value from the row
		
		
		
		
		
		
		
	}

}
