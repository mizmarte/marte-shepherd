package com.techelevator;

//ACME Machines,1000.00,300.00
//Coyote ATMs,500.00,0.00
//RoadRunner LLC,700.00,450.00
//Yosemite Sam Enterprises,1300.00,275.00

public class TellerMachine 
{
	private String manufacturer;
	private double deposits;
	private double withdrawals;
	private double balance;
	
//	getters
	public String getManufacturer()
	{
		return manufacturer;
	}
	public double getDeposits()
	{
		return deposits;
	}
	public double getWithdrawals()
	{
		return withdrawals;
	}
	
//	constructor
	public TellerMachine(String manufacturer, double deposits, double withdrawals)
	{
		this.manufacturer = manufacturer;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
	}

//	derived
	public double balance()
	{
		balance = getDeposits() - getWithdrawals();
		
		return balance;
	}
	
//	method
	public boolean isThisCardValid(String cardNumber)
	{
		boolean isThisCardValid;
		
		if(cardNumber.startsWith("5") && cardNumber.length()== 16)
		{
			return isThisCardValid = true;
		}
		else if(cardNumber.startsWith("4") && cardNumber.length()== 13 || cardNumber.length() == 16)
		{
			return isThisCardValid = true;
		}
		else if(cardNumber.startsWith("34")||cardNumber.startsWith("37"))
		{
			return isThisCardValid = true;
		}
		return isThisCardValid = false;
	}
	@Override
	public String toString()
	{
		return "ATM - " + manufacturer + " - " + balance;
	}
}
