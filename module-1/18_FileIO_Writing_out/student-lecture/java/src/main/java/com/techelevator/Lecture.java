package com.techelevator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture
{

	public static void main(String[] args) //throws IOException (put in try catch block)
	{

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.
		 * It provides methods to inspect and modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of
		 * '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file
		 * system path
		 */
		System.out.println("Enter a file name: ");
		String path = userInput.nextLine();
		
		File file = new File(path);
		
		System.out.println(file);
		System.out.println(file.getAbsolutePath());
		
//		if(file.exists())
//		{
//			file.delete();
//			System.out.println("deleting file");
//		}
		try
		{
			//boolean isFileCreated = file.createNewFile();
			
			//System.out.println("Created file: " + isFileCreated);
			
			
			System.out.println("Add text: ");
			String line = userInput.nextLine();
			
			//write to the file
			//FileOutputStream fileStream = new FileOutputStream(file);//it will create or overwrite content
			//in order to append to an existing file, you have to create the fileoutput stream directly and specify append=true
			// file true also allows us to create a new file and add text to it
			FileOutputStream fileStream = new FileOutputStream(file, true);//will append
			
			//BufferedOutputStream fileBuffer = new BufferedOutputStream(fileStream);
			PrintStream fileWriter = new PrintStream(fileStream);
			
		
			fileWriter.println(line);
			fileWriter.flush();//memory management, flushes buffer before you close it
			
			fileWriter.close();
//			System.out.println();
//			System.out.println(line);
		}
		catch (Exception e)
		{
			
		}

		
		

	}

}
