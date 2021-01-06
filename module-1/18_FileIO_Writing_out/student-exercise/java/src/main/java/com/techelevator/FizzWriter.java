package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FizzWriter 
{

	public static void main(String[] args) 
	{
		File FizzBuzz = new File("FizzBuzz.txt");//declare
		String outputString = "";
		try // initialize it in the try
		// try with resource
		
			
		(
				FileWriter oneTo300 = new FileWriter(FizzBuzz);
				PrintWriter fissbuss = new PrintWriter(oneTo300);
		) //opening up object to write data to text file
				{	
			for(int i = 1; i <=300; i++) //logic
			{
				 if(i % 15 == 0)
					{
					 outputString = "FizzBuzz";

					}
				 else if(i % 5==0 || Integer.toString(i).contains("5") )
				 {
					 outputString = "Buzz";
				 }
				 else if(i % 3==0 || Integer.toString(i).contains("3") )
				 {
					 outputString = "Fizz";
				 }
				 else
				 {
					 outputString = Integer.toString(i);
				 }
				 fissbuss.println(outputString);
			}	
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
		
		
	

}
