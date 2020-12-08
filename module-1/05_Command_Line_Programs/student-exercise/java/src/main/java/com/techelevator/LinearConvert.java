package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) 
	{

Scanner scanner = new Scanner(System.in);
		
		//Ask user for input of length
		
		System.out.print("Please enter a length: ");
		String length = scanner.nextLine();
		
		System.out.print("Is length in (m)eters or (f)eet?");
		String unit = scanner.nextLine();
		
		//if user enters meters
		
		if (unit.equalsIgnoreCase("m"))
		{
			int convertedMLength = Integer.parseInt(length);
			double footLength = convertedMLength * 3.2808399;
			System.out.print(length + " m is " + footLength + " ft.");
		}
		
		//if user enters feet
		else
		{	
		int convertedFLength = Integer.parseInt(length);
		double metersLength =  convertedFLength * 0.3048;
		System.out.print(length + " ft is " + metersLength + " m.");
		}
		
	}

}
