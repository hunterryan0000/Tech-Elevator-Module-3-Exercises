package com.techelevator;

import com.techelevator.auction.Auction;
import com.techelevator.auction.Bid;
import com.techelevator.auction.BuyoutAuction;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");
        System.out.printf("New auction for %s", generalAuction.getItemForSale());

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        BuyoutAuction buyoutAuction = new BuyoutAuction("Ninja Turtles Shirt", 30);

        buyoutAuction.placeBid(new Bid("Ryan", 25));
        buyoutAuction.placeBid(new Bid("Mary", 35));
        buyoutAuction.placeBid(new Bid("Mick", 40));


    }
}
