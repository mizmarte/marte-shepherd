package com.techelevator;

import java.math.BigDecimal;

//Basic,0
//Elite,12
//Elegant,24
//Apology,48
//Nuptial,18
//Bereavement,12

public class FlowerShopOrder 
{
	private String bouquetType;
	private int numberOfRoses;
	
	
	//getters
		public String getBouquetType()
		{
			return bouquetType;
		}
		public int getNumberOfRoses()
		{
			return numberOfRoses;
		}
//		derived
		public double getSubtotal()
		{
			double subtotal = 19.99 + (getNumberOfRoses() * 2.99);
			
			return subtotal;
		}
		
	//constructor
		public FlowerShopOrder(String bouquetType, int numberOfRoses)
		{
			this.bouquetType = bouquetType;
			this.numberOfRoses = numberOfRoses;
		}
	//method

		
		boolean sameDayDelivery;
		String zipCode;
		int zipCodeInt = Integer.parseInt(zipCode);

		double deliveryTotal;
		public double deliveryTotal(boolean sameDayDelivery, String zipCode)
		{
			if (sameDayDelivery == true)
			{
				if (zipCodeInt >= 20000 && zipCodeInt <= 29999)
				{
					return deliveryTotal = 9.98;
				}
				else if (zipCodeInt >= 30000 && zipCodeInt <= 39999) 
				{
					return deliveryTotal = 12.98;
				}
			}
			if (sameDayDelivery == false)
			{
				if (zipCodeInt >= 20000 && zipCodeInt <= 29999)
				{
					return deliveryTotal = 3.99;
				}
				else if (zipCodeInt >= 30000 && zipCodeInt <= 39999)
				{
					return deliveryTotal = 6.99;
				}
				
			}
			if (zipCodeInt >= 10000 && zipCodeInt <= 19999)
				{
					return deliveryTotal = 0.00;
				}
			else if (zipCodeInt < 10000 || zipCodeInt > 39999)
			{
				return deliveryTotal = 19.99;
			}	
			return deliveryTotal;
		}
		
		public double grandTotal()
		{
			double grandTotal;
			
			grandTotal = deliveryTotal + getSubtotal();
			
			return grandTotal;
		}
		
		@Override
		public String toString()
		{
			return "ORDER - " + bouquetType + " - " + numberOfRoses + " roses " + " - " + getSubtotal();
		}
		
		
}
