package com.techelevator;
//Godfather,DVD,true
//The Room,VHS,false
//Fast and Furious,Blu-ray,false
//1984,Blu-ray,true
//Soylent Green,DVD,true
//Star Trek 4: The Voyage Home,VHS,false
//Star Wars: The Phantom Menace,Blu-ray,false



public class MovieRental 
{
	//what does it know
	private String title;
	private String format;
	private boolean isPremium;
	private double rentalPrice;
	
	//getters
	public String getTitle()
	{
		return title;
	}
	public String getFormat()
	{
		return format;
	}
	public boolean isPremium()
	{
		return this.isPremium;
	}
//	public double getRentalPrice()
//	{
//		return rentalPrice;
//	}
	
	
	//constructor
	public MovieRental(String title, String format, boolean isPremium)
	{
		this.title = title;
		this.format = format;
		this.isPremium = isPremium;
	}
	
	//methods - objects
	public double rentalPrice(String format,boolean isPremium)
	{
		if (format.equals("VHS"))
		{
			if(isPremium == true)
			{
				return rentalPrice = 1.99;
			}
			if(isPremium == false)
			{
				return rentalPrice = 0.99;
			}
		}	
		if (format.equals("DVD"))
		{
			if(isPremium == true)
			{	
				return rentalPrice = 2.99;
			}
			if(isPremium == false)
			{
				return rentalPrice = 1.99;
			}
			
		}	
		
		if (format.equals("Blu-Ray"))
		{
			if(isPremium == true)
			{
				return rentalPrice = 3.99;
			}
			if(isPremium == false)
			{
				return rentalPrice = 2.99;
			}
			
		}	
		return rentalPrice;
	}
	
	public double lateFee(int daysLate, double rentalPrice)
	{
		if (daysLate == 0)
		{
			return rentalPrice += 0;
		}
		else if (daysLate == 1)
		{
			return rentalPrice += 1.99;
		}
		else if (daysLate == 2)
		{
			return rentalPrice += 3.99;
		}
		else if (daysLate >= 3)
		{
			return rentalPrice += 19.99;
		}
		
		return rentalPrice;
	}
	@Override
	public String toString()
	{
		return "MOVIE - " + title + " - " + format + " $" + rentalPrice;
	}
}

