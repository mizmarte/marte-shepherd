//Please enter the Fibonacci number: 25
//
//0, 1, 1, 2, 3, 5, 8, 13, 21


package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) 
	{

		Scanner scanner = new Scanner(System.in);
		//To get the Fibonacci Number
		System.out.print("Please enter the Fibonacci number: ");
		
		String fibonacci = scanner.nextLine();
		
		System.out.println();
		
		int fibConvert = Integer.parseInt(fibonacci);
		
		int i = 0;
		int firstNumOfFib = 0;
		int secondNumOfFib = 1;
		int sumOfFib = firstNumOfFib + secondNumOfFib;
		
		System.out.print("0 1");
		
		while (firstNumOfFib + secondNumOfFib < fibConvert)
		{
			sumOfFib = firstNumOfFib + secondNumOfFib;
			
			System.out.print(" " + sumOfFib);
			
			firstNumOfFib = secondNumOfFib;
			
			secondNumOfFib = sumOfFib;
			
		}
		
		//keep track of current number and previous 2 numbers
		
		
	}

}
