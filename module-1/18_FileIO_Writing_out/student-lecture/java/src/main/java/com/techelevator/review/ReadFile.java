package com.techelevator.review;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        String fileName;
        File file;

        // 1. specify the file path (user input)
        System.out.print("Enter the name of a file >>> ");
        fileName = userInput.nextLine();

        // 2. create a File object from the path
        file = new File(fileName);


        if(file.exists())
        {
            getFileStatistics(file);
        }
        else
        {
            System.out.println("The file '" + file + "' does not exist.' ");
        }

    }

    public static void getFileStatistics(File file)
    {

    	// try with resource
        try (Scanner fileStream = new Scanner(file))
        {
            // 3. open the file as a file stream
        	// creates a lock on the file
//            Scanner fileStream = new Scanner(file);

            // 4. process each word/line in the stream
            while(fileStream.hasNext())
            {
                String word = fileStream.next();
                // do something with the file
            }

            //close the file to release lock
            fileStream.close();
        }
        catch (FileNotFoundException ex)
        {
        	//runs if there is an exception
            System.out.println(ex.getMessage());
        }
        finally
        {
        	//this always runs whether or not there is an exception
        	//clean up code
        	
        }
    }
}
