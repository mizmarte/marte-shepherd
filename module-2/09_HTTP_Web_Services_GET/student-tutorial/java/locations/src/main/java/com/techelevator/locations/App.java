package com.techelevator.locations;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;



public class App {

	private static final String BASE_URL = "http://localhost:3000/locations";
	private static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) 
	{
		run();
	}

	  private static void run() 
	  {
		  
		  Scanner scanner = new Scanner(System.in);
		  printGreeting();
		  int menuSelection = 0;
		   
	        try 
	        {
	            menuSelection = Integer.parseInt(scanner.nextLine());
	        } 
	        catch (NumberFormatException exception) 
	        {
	            System.out.println("Error parsing the input for menu selection.");
	        }
	            System.out.println("");
	            
	            if (menuSelection == 1) 
	            {
	            	// get all TE locations from the API
	            	Location[] locations = restTemplate.getForObject(BASE_URL, Location[].class);
	            	// and display them
	            	printLocations(locations);
	            	
	            	int id = 0;
	            	
	            	try
	            	{
	            		id = Integer.parseInt(scanner.nextLine());
	            	}
	            	catch (NumberFormatException exception)
	            	{
	            		System.out.println("Error parsing the input for menu selection.");
	            	}
	             
	            	if (id> 0 && id <= locations.length) 
	            	{
	            		Location location = restTemplate.getForObject(BASE_URL + "/" + id, Location.class);
	            		printLocation(location);
	            	}
	            	else
	            	{
	            		System.out.println("Invalid Location Id");
	            	}
	            }
	            else if (menuSelection == 2)
	            {
	            	System.out.println("Thank you.  Have a nice day.");
	            	scanner.close();
	            	System.exit(0);
	            }
	            else
	            {
	            	System.out.println("Invalid Selection");
	            }
                
	         
		  
	  }

  private static void printGreeting() {
    System.out.println("");
    System.out.println("Welcome to Tech Elevator Locations. Please make a selection: ");
    System.out.println("1: List Tech Elevator Locations");
    System.out.println("2: Exit");
    System.out.println("");
    System.out.print("Please choose an option: ");
  }

  private static void printLocations(Location[] locations) {
    System.out.println("--------------------------------------------");
    System.out.println("Locations");
    System.out.println("--------------------------------------------");
    for (Location location : locations) {
      System.out.println(location.getId() + ": " + location.getName());
    }
    System.out.println("");
    System.out.print("Please enter a locsation id to get the details: ");
  }

  private static void printLocation(Location location) {
    System.out.println("");
    System.out.println("--------------------------------------------");
    System.out.println("Location Details");
    System.out.println("--------------------------------------------");
    System.out.println("Id: " + location.getId());
    System.out.println("Name: " + location.getName());
    System.out.println("Address: " + location.getAddress());
    System.out.println("City: " + location.getCity());
    System.out.println("State: " + location.getState());
    System.out.println("Zip: " + location.getZip());
  }

  
}
