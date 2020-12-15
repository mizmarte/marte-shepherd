package com.techelevator;

public class ReserveAuction extends Auction
{
	private int reservePrice;
	public ReserveAuction(String itemForSale)
	{
		super(itemForSale);
		
		this.reservePrice = reservePrice;
	}
	public int getReservePrice()
	{
		return reservePrice;
	}

	
//	public boolean (placeBid(Bid offeredBid)
//			{
//		
//				if(offeredBid.getBidAmount() >= reservePrice)
//				{
//					return super.placeBid(offeredBid);
//				}
//			}			
//			return false;

}


