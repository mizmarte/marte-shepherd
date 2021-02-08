package com.techelevator.views;

import java.util.Scanner;

public class UserInput
{
	protected static Scanner console = new Scanner(System.in);
	
	public static int getHomeMenuOption()
	{
		System.out.println("What would you like to do?");
		System.out.println();

		System.out.println("1) Display Products");
		System.out.println("2) Select Product");
		System.out.println("0) Exit");
		
		System.out.println();
		System.out.print("Please select an option: ");
		
		int selection = Integer.parseInt(console.nextLine());
		System.out.println();
		
		return selection;
		
	}
	
}
