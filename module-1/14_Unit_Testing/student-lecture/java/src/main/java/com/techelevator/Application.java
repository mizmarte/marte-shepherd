package com.techelevator;

import java.util.Scanner;

public class Application 
{
	
	private Scanner scanner = new Scanner(System.in);
	
	public void run()
	{
		int counter = 0;
		while(true)
		{
			System.out.println("What do you want to do next?");
			System.out.println("[C]ontinue or [Q]uit:");
			String input = scanner.nextLine();
			
			
			if (input.trim().toLowerCase().equals("C"))
			{
				System.out.println("Welcome back - continuing");
			}
			else
			{
				System.out.println("Goodbye");
				break;
			}
		}
		
		
	}
}
