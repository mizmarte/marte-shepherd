package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		//Ask for user input of temperatures
		
		System.out.print("Please enter a temperature: ");
		String temp = scanner.nextLine();
		
		System.out.print("Is it temperature in (C)elsius or (F)arenheit? ");
		String unit = scanner.nextLine();
		
		//if user enters Celsius
		
		if (unit.equalsIgnoreCase("C"))
		{
			int convertedTemp = Integer.parseInt(temp);
			double farenheitTemp = (convertedTemp * 1.8) + 32;
			System.out.print(temp + "C is " + farenheitTemp + "F.");
			
		}

		//if temp isn't Celsius
		else
		{	
		int convertedFTemp = Integer.parseInt(temp);
		double celsiusTemp = (convertedFTemp - 32) / 1.8;
		System.out.print(temp + "F is " + celsiusTemp + "C.");
		}
	}

}
