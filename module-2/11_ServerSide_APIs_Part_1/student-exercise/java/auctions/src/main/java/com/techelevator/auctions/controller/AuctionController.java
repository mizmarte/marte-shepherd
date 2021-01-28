package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController 
{

	private AuctionDAO dao;

	public AuctionController() 
	{
		this.dao = new MemoryAuctionDAO();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Auction> list() 
	{
        return dao.list();
        
    }
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Auction get(@PathVariable int id)
	{
		return dao.get(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody Auction auction)
	{
		dao.create(auction);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public  List<Auction> list
	(@RequestParam(value="title_like", defaultValue = "") String title)
	{
		if (title.length() > 0)
		{
			return dao.searchByTitle(title);
		}
		return dao.list();
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public  List<Auction> list
	(@RequestParam(value="currentBid_lte", defaultValue = "0") double currentBid_lte) 
	{
		if (currentBid_lte > 0)
		{
			return dao.searchByPrice(currentBid_lte);
		}
		return dao.list();
		
	}
	
}
