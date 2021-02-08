package com.techelevator.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.exceptions.AuthenticationServiceException;
import com.techelevator.models.Product;

public class ProductService
{
	public static String AUTH_TOKEN = "";
	private String BASE_URL;
	private RestTemplate restTemplate = new RestTemplate();

	public ProductService(String url)
	{
		this.BASE_URL = url + "products";
	}
	
	public List<Product> getAllProducts()
	{
		List<Product> products;
		
		Product[] productsArray = restTemplate.getForObject(BASE_URL, Product[].class);		
		products = Arrays.asList(productsArray);
		
		return products;		
	}
	
	public Product getProductById(int id)
	{
		String url = BASE_URL + "/" + id;
		Product product = restTemplate.getForObject(url, Product.class);
		
		return product;		
	}
	public void deleteProductById(int id) //throws AuthenticationServiceException
	{
		String url = BASE_URL + "/" + id;
        	restTemplate.delete(url);
 	
	}
}
