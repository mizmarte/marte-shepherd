package com.techelevator.application;

import com.techelevator.models.CashRegister;
import com.techelevator.models.Inventory;
import com.techelevator.models.products.Product;
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
	
	private Inventory inventory = new Inventory();
	
    public void run()
    {

        while(true)
        {
            // display main menu - get their selection
            String option = UserInput.getHomeScreenOption();
            

            if(option.equals("add"))
            {
                // do add item task
            	addToCart();
            }
           else if(option.equals("pay"))
            {
            	checkOut();
                // go to cash register to check out
                break;
            }
            else if(option.equals("cart"))
            {
            	//display the cart
            	showCart();
            }
            else if(option.equals("quit"))
            {
          
            	break;
            }
            else
            {
            	//invalid option try again
            }

        }
        
    }
    public void addToCart()
    {
    	//show the products
    	UserOutput.displayInventory(inventory);
    	//prompt user for input
    	String productId = UserInput.getSelectedProduct();
    	
    	//find the product based on the id
    	Product product = null;
    	for (Product p: inventory.getProducts())
    	{
    		if(p.getId().equals(productId))
    		{
    			product = p;
    			break;
    		}	
    	}
    	//add that product to cart
    	System.out.println("User Selected: " + product.toString());
    }
    public void showCart()
    {
    	
    }
    public void checkOut()
    {
    	
    }
}
