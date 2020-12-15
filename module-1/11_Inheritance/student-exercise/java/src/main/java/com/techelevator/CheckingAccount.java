package com.techelevator;

public class CheckingAccount extends BankAccount
{

	public CheckingAccount(String accountHolderName, String accountNumber, int balance)
		{
			super(accountHolderName, accountNumber, balance);
		
		}
	public CheckingAccount(String accountHolderName, String accountNumber)
	{
		super(accountHolderName, accountNumber);
	}
	
	@Override
	public int withdraw(int amountToWithdraw)
	{
		int overdraftFee = 10;
		if (getBalance() - amountToWithdraw <= -100)
		{
			return getBalance();
		}


		else if (getBalance() - amountToWithdraw < 0)
		{
			return super.withdraw(amountToWithdraw + overdraftFee);
		}
		else  return super.withdraw(amountToWithdraw);
		
		
	}
}
