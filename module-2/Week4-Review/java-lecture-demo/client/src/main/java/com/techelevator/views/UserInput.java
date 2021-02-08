package com.techelevator.views;

import java.util.List;

import java.util.Scanner;

import com.techelevator.models.Product;
import com.techelevator.models.UserCredentials;

public class UserInput
{
	protected static Scanner console = new Scanner(System.in);
	
	public static int getHomeMenuOption()
	{
		System.out.println("What would you like to do?");
		System.out.println();

		System.out.println("1) Display Products");
		System.out.println("2) Select Product");
		System.out.println("3) Delete Product");
		System.out.println("4) Login");
		System.out.println("0) Exit");
		
		System.out.println();
		System.out.print("Please select an option: ");
		
		int selection = Integer.parseInt(console.nextLine());
		System.out.println();
		
		return selection;
		
	}

	public static int getProductSelection(List<Product> products)
	{
		System.out.println();
		System.out.print("Select a product: ");

		String slot = console.nextLine();
		System.out.println();
		
		// look for the product in the slot
		for (Product product : products)
		{
			if(product.getSlot().equalsIgnoreCase(slot))
			{
				return product.getId();
			}
		}
		
		return -1;
		
	}

	public static int getProductDeletion(List<Product> products) 
	{
		System.out.println();
		System.out.print("Select a product: ");

		String slot = console.nextLine();
		System.out.println();
		
		// look for the product in the slot
		for (Product product : products)
		{
			if(product.getSlot().equalsIgnoreCase(slot))
			{
				int result = product.getId();
				
				return result;
			
			}
			
		}
		return 0;
	}
	public static String promptForLogin() {
        String credentials = "";
        System.out.println("Enter username,password");
        credentials = console.nextLine();
        return credentials;
    }
}
