package com.techelevator.ui;

import java.util.Scanner;

/**
 * Responsibilities:
 *      This class should handle receiving ALL input from the User
 * 
 * Dependencies:
 *      None
 */
public class UserInput 
{
   private static Scanner scanner = new Scanner(System.in);
   
//   public static String getHomeScreenOption()
   
   public static String getSelectedProduct()
   {
	   System.out.println("Which product do you want? ");
	   String productId = scanner.nextLine();
	   
	   return productId.trim();
   }
   {
	   System.out.println();
	   System.out.println("What would you like to do?");
	   System.out.println();
	   
	   System.out.println("a) Add product to cart");
	   System.out.println("b) View Chart");
	   System.out.println("c) Checkout");
	   System.out.println("d) Quit");
	   
	   System.out.println();
	   System.out.println("Please select an option:");
	   
	   String selectedOption = scanner.nextLine();
	   String option = selectedOption.trim().toLowerCase();
//	   
//	   if (option.equals("a"))
//	   {
//		   return "add";
//	   }
//	   else if (option.equals("b"))
//	   {
//		   return "cart";
//	   }
//	   else if (option.equals("c"))
//	   {
//		   return "pay";
//	   }
//	   else if (option.equals("d"))
//	   {
//		   return "quit";
//	   }
//   }
	
}}
