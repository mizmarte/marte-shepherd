package com.techelevator;

public class BankAccount 
{
	// what does it know - PRIVATE VALUES
	private String accountHolderName;
	private String accountNumber;
	private int balance;
		//here's the GETTERS
	
		public String getAccountHolderName()
		{
			return accountHolderName;
		}
		public String getAccountNumber()
		{
			return accountNumber;
		}
		public int getBalance()
		{
			return balance;
		}
		
	
		//here's the Constructors
		public BankAccount(String accountHolderName, String accountNumber)
		{
			this.accountHolderName = accountHolderName;
			this.accountNumber = accountNumber;
			balance = 0;
			
		}
		public BankAccount(String accountHolderName, String accountNumber, int balance)
		{
			this.accountHolderName = accountHolderName;
			this.accountNumber = accountNumber;
			this.balance = balance;
		}
		
		
		public int deposit(int amountToDeposit)
		{
			{
				return balance += amountToDeposit;
			}
		
		}
		public int withdraw(int amountToWithdraw)
		{
			{
				return balance -= amountToWithdraw;
			}
			
		}
}


