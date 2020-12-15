package com.techelevator;

public class BuyoutAuction extends Auction 
{
	private int buyOutPrice;
	private boolean noNewBids;
	public BuyoutAuction(String itemForSale, int buyOutPrice)
	{
		//you MUST call super constructor 
		//BEFORE you can do anyting else
		//pass in the arguments that it needs
		super(itemForSale);
	
		this.buyOutPrice = buyOutPrice;	
		boolean noNewBids;

	}
	
	public int getBuyOutPrice()
	{
		return buyOutPrice;
	}
	public void buyNow(Bid bid)
	{
		if(bid.getBidAmount()>= buyOutPrice)
		{
			boolean isHighBid = this.placeBid(bid);
			noNewBids = isHighBid;
			//end the auction
		}
	}
	
	@Override
	public boolean placeBid(Bid offeredBid)
	{
		//allow bids
		if(!noNewBids) 
		{
			return super.placeBid(offeredBid);
		}
	
		return false;
	}
}




