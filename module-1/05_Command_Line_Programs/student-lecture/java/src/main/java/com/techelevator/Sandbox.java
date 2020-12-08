package com.techelevator;

import java.util.Scanner;

public class Sandbox 
{
	/*
	 In case you've ever pondered how much you weight on Mars, here's the calculation:
	 	Wm = We * 0.378
	 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
	 
	Write a command line program which accepts a series of Earth weights from the user  
	and displays each Earth weight as itself, and its Martian equivalent.

	 $ MartianWeight 
	 
	Enter a series of Earth weights (space-separated): 98 235 185
	 
	 98 lbs. on Earth, is 37 lbs. on Mars.
	 235 lbs. on Earth, is 88 lbs. on Mars.
	 185 lbs. on Earth, is 69 lbs. on Mars. 
	 */

		public static void main(String[] args) 
		{
			 Scanner scanner = new Scanner(System.in);
			 
				System.out.print("Please provide a series of Earth weights (space separated): ");
				String weights = scanner.nextLine();

				// Split the string up into separate values
				String[] weightArray = weights.split(" ");

				System.out.println();
				
				for (int i = 0; i < weightArray.length; i++)
				{
					// Read the individual value as a decimal
					double weightdecArray = Double.parseDouble(weightArray[i]);


					double marsWeight = weightdecArray * 0.378;

					System.out.println(weightArray[i] + "lbs. on earth, is " + marsWeight + " lbs. on Mars. ");
				}

				
			
			
		}
}
