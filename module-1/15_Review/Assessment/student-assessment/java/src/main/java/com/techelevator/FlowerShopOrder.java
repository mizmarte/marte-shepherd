package com.techelevator;

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
	private double subtotal;
	
	//getters
		public String getBouquetType()
		{
			return bouquetType;
		}
		public int getNumberOfRoses()
		{
			return numberOfRoses;
		}
		
	//constructor
		public FlowerShopOrder(String bouquetType, int numberOfRoses)
		{
			this.bouquetType = bouquetType;
			this.numberOfRoses = numberOfRoses;
		}
	//method
		public double subtotal()
		{
			subtotal = 19.99 + (getNumberOfRoses() * 2.99);
			
			return subtotal;
		}
		
		boolean sameDayDelivery;
//		String zipCode;
//		zipCodeInt = Integer.parseInt(zipCode);
		int zipCode;
		double deliveryTotal;
		public double deliveryTotal(boolean sameDayDelivery, int zipCode)
		{
			if (sameDayDelivery == true)
			{
				if (zipCode >= 20000 && zipCode <= 29999)
				{
					return deliveryTotal = 9.98;
				}
				else if (zipCode >= 30000 && zipCode <= 39999) 
				{
					return deliveryTotal = 12.98;
				}
			}
			if (sameDayDelivery == false)
			{
				if (zipCode >= 20000 && zipCode <= 29999)
				{
					return deliveryTotal = 3.99;
				}
				else if (zipCode >= 30000 && zipCode <= 39999)
				{
					return deliveryTotal = 6.99;
				}
				
			}
			if (zipCode >= 10000 && zipCode <= 19999)
				{
					return deliveryTotal = 0.00;
				}
			else if (zipCode < 10000 || zipCode > 39999)
			{
				return deliveryTotal = 19.99;
			}	
			return deliveryTotal;
		}
		
		public double grandTotal()
		{
			double grandTotal;
			
			grandTotal = deliveryTotal(sameDayDelivery,zipCode) + subtotal();
			
			return grandTotal;
		}
		
		@Override
		public String toString()
		{
			return "ORDER - " + bouquetType + " - " + numberOfRoses + " roses " + " - " + subtotal();
		}
		
		
}
