package com.techelevator.application;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.models.Chore;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class Application
{
	//private variables - dependency classes for UI
    UserInput input = new UserInput();//prompt user input
    UserOutput output = new UserOutput();//use to display something to user

    //private variables
    List<Chore> chores;
    
    //constructor
    public Application()
    {
        // create instance variables here
        chores = new ArrayList<Chore>();
    }

    public void run()
    {
        output.displayWelcomeScreen();

        while(true)
        {
            int choice = input.getMainMenuChoice();

            if(choice == 1)
            {
                addChore();
            }
            else if(choice == 2)
            {
                showChores();
            }
            else if(choice == 3)
            {
                break;
            }
            else
            {
                output.displayMessage("Please select from the list of options.");
            }

        }

        output.displayGoodbye();

    }

    private void addChore()
    {
    	// get chore name
    	String choreName = input.getChoreName();
    	
    	//get person name
    	String personName = input.getPersonName();
    	
    	//create a chore
    	Chore chore = new Chore(choreName, personName);
    	
    	//add the chore to the list
    	
    	chores.add(chore);
    	
    	
    }

    private void showChores()
    {
    	for (Chore chore: chores)
    	{
    		output.displayMessage(chore.toString());
    	}
    	
    }
    
}
