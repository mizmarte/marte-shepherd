package com.techelevator.application;

import com.techelevator.models.CashRegister;
import com.techelevator.models.Inventory;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

/**
 * The store class is the main application.
 * 
 * Responsibilities:
 *      manage the flow of the application
 * 
 * Dependencies:
 *      Inventory
 *      ShoppingCart
 *      CashRegister
 * 
 *      UI:
 *      UserInput
 *      UserOutput
 * 
 *      Utility:
 *      Logger - used to log errors and transactions
 */
public class Store 
{
	
	
	private Inventory inventory;
	
    public void run()
    {

        while(true)
        {
            // display main menu - get their selection
//            String option = userInput.getHomeScreenOption();
//
//            if(option.equals("add"))
            {
                // do add item task
            	System.out.println("user chose add");
            	addToCart();
            }
//            else if(option.equals("pay"))
            {
            	System.out.println("user chose pay");
                // go to cash register to check out
                break;
            }}
//            else if(option.equals("cart"))
//            {
//            	System.out.println("user chose cart");
//            	//display the cart
//            }
//            else if(option.equals("quit"))
//            {
//            	System.out.println("user chose quit");
//            	break;
//            }
//            else
//            {
//            	
//                // invalid option try again
//            }
//
//        }
//        
    }
    public void addToCart()
    {
 
    }
    public void showCart()
    {
    	
    }
    public void checkOut()
    {
    	
    }
}
