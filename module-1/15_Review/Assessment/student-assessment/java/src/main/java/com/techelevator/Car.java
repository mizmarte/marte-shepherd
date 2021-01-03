package com.techelevator;

//1965,Ford Mustang,true
//2019,Subaru,false
//1920,Baker Electric,true
//1970,Pontiac GTO,true
//2018,Toyota Camry,false

public class Car 
{
//	what does it know
	private int year;
	private String make;
	private boolean isClassicCar;
	private int age;
	
//	getters
	public int getYear()
	{
		return year;
	}
	public String getMake()
	{
		return make;
	
	}
	public boolean isClassicCar()
	{
		return isClassicCar;
	}
	public int age()
	{
		int currentYear = 2021;
		age = currentYear - year;
		return age;
	}
//	constructors
	public Car(int year, String make, boolean isClassicCar)
	{
		this.year = year;
		this.make = make;
		this.isClassicCar = isClassicCar;
	}
//	method
	public boolean isECheckRequired(int yearToCheck)
	{
		boolean isECheckRequired = false;
		if (age < 4 || age > 25 || isClassicCar == true)
		{
			return isECheckRequired = false;
		}
		if(yearToCheck % 2 == 0)
		{
			if (year % 2 ==0)
			{
				return isECheckRequired = true;
			}
			if (year % 2 !=0)
			{
				return isECheckRequired = false;
			}
		}
		if(yearToCheck % 2 != 0)
		{
			if (year % 2 !=0)
			{
				return isECheckRequired = true;
			}
			if (year % 2 ==0)
			{
				return isECheckRequired = false;
			}
		}
		return isECheckRequired;
	}
	public String toString()
	{
		return "CAR - " + year + " - " + make ;
	}
	
	
	
	
}
