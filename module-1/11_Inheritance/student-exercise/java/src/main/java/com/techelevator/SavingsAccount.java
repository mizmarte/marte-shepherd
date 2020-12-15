package com.techelevator;

public class SavingsAccount extends BankAccount
{

	public SavingsAccount(String accountHolderName, String accountNumber, int balance)
		{
			super(accountHolderName, accountNumber, balance);
		
		}
	public SavingsAccount(String accountHolderName, String accountNumber)
	{
		super(accountHolderName, accountNumber);
	}
	
	@Override
	public int withdraw(int amountToWithdraw)
	{
		int serviceCharge = 2;
		
		if (getBalance() < amountToWithdraw)
		{
			return getBalance();	
		}
		else if (getBalance() - amountToWithdraw < 150)
		{
			return super.withdraw(amountToWithdraw + serviceCharge);
		}
		else  return super.withdraw(amountToWithdraw);
		
	}
	
	
	
	
	
	
}
