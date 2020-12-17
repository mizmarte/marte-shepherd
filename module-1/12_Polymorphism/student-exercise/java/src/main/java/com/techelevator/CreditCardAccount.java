package com.techelevator;

public class CreditCardAccount implements Accountable
{	
	private int getBalance;
	private String accountHolder;
	private String accountNumber;
	private int debt;
	
	@Override
	public int getBalance() 
	{
		// TODO Auto-generated method stub
		return -debt;
	}
	
	public CreditCardAccount (String accountHolder, String accountNumber)
	{
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.debt = debt;
				
	}
	public String getAccountHolder()
	{
		return accountHolder;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public int getDebt()
	{
		return debt;
	}
	public int pay(int amountToPay)
	{
		debt = getDebt() - amountToPay;
		return debt;
	}
	public int charge(int amountToCharge)
	{
		debt = getDebt() + amountToCharge;
		return debt;
	}
	



}


