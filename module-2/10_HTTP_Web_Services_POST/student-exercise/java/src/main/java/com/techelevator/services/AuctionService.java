package com.techelevator.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


import com.techelevator.models.Auction;

public class AuctionService {

    public static final String API_URL = "http://localhost:3000/auctions";

    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();

    public Auction[] listAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_URL, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("Could not retrieve the auctions. Is the server running?");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction listDetailsForAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_URL + "/" + id, Auction.class);
        } catch (RestClientResponseException ex) {
            console.printError("Could not retrieve the auction.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auction;
    }

    public Auction[] findAuctionsSearchTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("The title was not found. Please try again.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction[] findAuctionsSearchPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("No auctions found. Please try again.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction add(String auctionString) 
    {
    	Auction newAuction = makeAuction(auctionString);
    	
    	String url = API_URL;
    	
    	 HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         
         HttpEntity<Auction> makeEntity = new HttpEntity<>(newAuction, headers);
          
 		try
 		{
 			Auction auction = restTemplate.postForObject(url, makeEntity, Auction.class);
 			return auction;
 		}
 		catch (Exception e)
 		{
 			return null;
 		}
 		
         
         
         // place code here
         
    	 
    }

    public Auction update(String auctionString) 
    {
    	// create the body
    	Auction auctionToUpdate = makeAuction(auctionString);
    	
		// append the ID as the WHERE clause for the update statement
    	String url = API_URL + "/" + auctionToUpdate.getId();
    	
    	// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); // what data type to expect in the body
		
		HttpEntity<Auction> entity = new HttpEntity<Auction>(auctionToUpdate, headers);
    	
		try
		{
			// put() does not return a response or object
			restTemplate.put(url, entity);
			return auctionToUpdate;
		} 
		catch (Exception e)
		{
			// TODO: handle exception			
			return null;
		}
    }

    public boolean delete(int id) throws RestClientResponseException, ResourceAccessException 
    {
    	// place code here
    	
    	String url =API_URL + "/" + id;
    	
    	try
    	{
    		restTemplate.delete(url);
    		return true;
        }
    	catch (RestClientResponseException ex)
    	{
    		console.printError("Could not retrieve the requested auction. Is the server running?");
    	}
    	catch (ResourceAccessException ex)
    	{
    		console.printError("A network error occurred. Please try again.");
    	}
    	return false;
    	
    	
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> entity = new HttpEntity<>(auction, headers);
        return entity;
    }

    private Auction makeAuction(String CSV) {
        String[] parsed = CSV.split(",");
        // invalid input
        if (parsed.length < 4 || parsed.length > 5) {
            return null;
        }
        // Add method does not include an id and only has 5 strings
        if (parsed.length == 4) {
            // Create a string version of the id and place into an array to be concatenated
            String[] withId = new String[6];
            Auction[] auctions = listAllAuctions();
            if (auctions == null) {
            	return null; // Some exception or other problem occurred.
            }
            String[] idArray = new String[]{auctions.length + 1 + ""};
            // place the id into the first position of the data array
            System.arraycopy(idArray, 0, withId, 0, 1);
            System.arraycopy(parsed, 0, withId, 1, 4);
            parsed = withId;
        }
        return new Auction(Integer.parseInt(parsed[0].trim()), parsed[1].trim(), parsed[2].trim(), parsed[3].trim(), Double.parseDouble(parsed[4].trim()));
    }


}
