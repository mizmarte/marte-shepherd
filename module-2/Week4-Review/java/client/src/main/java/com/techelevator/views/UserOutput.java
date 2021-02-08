package com.techelevator.views;

import java.util.List;

import com.techelevator.models.Product;

public class UserOutput
{
	public static void displayWelcome()
	{
		System.out.println("Welcome To The Vendor");
	}
	public static void displayProducts(List<Product> products)
	{
		System.out.println();
		System.out.println("------------------Products--------------------");
		
		for (Product product:products)
		{
			//System.out.println(products.getSlot() + " " + product.getName() + " $" + product.getPrice()) ;
		}
		System.out.println();
	}
}
