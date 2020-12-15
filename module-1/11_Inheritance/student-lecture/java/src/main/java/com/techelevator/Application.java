package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        
        Bid winningBid = generalAuction.getHighBid();
        System.out.println(winningBid.getBidder() + "wins the " + generalAuction.getItemForSale());
        System.out.println(winningBid.getBidAmount());
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        
        BuyoutAuction auction = new BuyoutAuction("Shirt", 10);
        
        Bid bid = new Bid("Mary", 10);
        
        auction.buyNow(bid);
        
        auction.placeBid(newBid("John", 20));

    }
}
