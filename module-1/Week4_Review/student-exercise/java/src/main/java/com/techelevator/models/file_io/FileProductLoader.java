package com.techelevator.models.file_io;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.models.products.Product;

/**
 * Responsibilities:
 *      Read a txt/csv file and convert each line to a product
 *      returns a list of all products found in the file
 * 
 * Dependencies:
 *      Product
 */
public class FileProductLoader 
{
  
	public List<Product> getProducts()
	{
		List<Product> products = new ArrayList<Product>();
		File productsPath = new File("data/products.csv");
		try(Scanner fileScanner = new Scanner(productsPath))
		{
			fileScanner.hasNextLine();
			
			while(fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine();
				
				//create product and add to list
				String[] parts = line.split(",");
				String id = parts[0];
				String name = parts[1];
				BigDecimal price = new BigDecimal parts[2];
				Product product = new Product(id, name, price);
				
				products.add(product);
				
			}
		}
		catch(Exception e)
		{
			
		}
		return products;
	}
	
}
