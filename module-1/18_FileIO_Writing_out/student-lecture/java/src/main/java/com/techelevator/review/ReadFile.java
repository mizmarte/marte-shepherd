package com.techelevator.review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
        
        getFileStatistics(file);

//        if(file.exists())
//        {
//            getFileStatistics(file);
//        }
//        else
//        {
//            System.out.println("The file '" + file + "' does not exist.' ");
//        }

    }

    public static void getFileStatistics(File file)
    {

//      write to file called "stats.txt"
      //create the resource
      File outFile = new File("stats.txt");
    	
    	
    	// try with resource - all code in block dependant on resource and no finally block needed 
//    		releases code at end of block so automatically does fileStream.close() so that's no longer needed
        try (
        		Scanner fileStream = new Scanner(file);
        		FileOutputStream out = new FileOutputStream(outFile); //if these are put here in try with resource, no need to 
        		PrintStream outStream = new PrintStream(out);			//manually close the resource
        		
        	)
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

//            //close the file to release lock
//            fileStream.close();
            
            //write to the file
            outStream.println("File Name: " + file.getName());
            outStream.println("File Size: " + file.getTotalSpace());
//            outStream.println("Word Count: " + counter);				from wordcount file
//            outStream.println("Sentence Count: " + sentenceCounter);	from wordcountfile
            
            //close the resource
//            outStream.close(); if you put your Scanner fileStream, FileOutputStream, and PrintStream in try-with-resource
//            						you do not need to manually close the resource
            
//          some file statistics listed below
            System.out.println("File Name: " + file.getName());
            System.out.println("File Size: " + file.getTotalSpace());
//            System.out.println("Word Count: " + counter);	            from wordcount file
//			System.out.println("Sentence Count: " + sentenceCounter);   from wordcount file
            System.out.println();
        }
        catch (FileNotFoundException ex)
        {
        	//runs if there is an exception
            System.out.println(ex.getMessage());
        }
//        finally
//        {
//        	//this always runs whether or not there is an exception
//        	//clean up code
//        	
//        }
 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
