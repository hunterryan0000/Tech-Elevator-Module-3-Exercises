package com.techelevator;

import com.techelevator.auction.Auction;
import com.techelevator.auction.Bid;
import com.techelevator.auction.BuyoutAuction;
import com.techelevator.auction.ReserveAuction;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");
        System.out.printf("New auction for %s. Enter your bids now!\n", generalAuction.getItemForSale());

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        // Who won the auction?
        Bid winner = generalAuction.getHighBid();
        System.out.printf("Winning Bid: %s placed a winning bid of %d\n",
                winner.getBidder(), winner.getBidAmount());
        // Note that here public parts of Auction are visible BUT NOT protected


        BuyoutAuction buyoutAuction = new BuyoutAuction("TMNJ T-Shirt", 30);

        buyoutAuction.placeBid(new Bid("Ryan", 25));
        buyoutAuction.placeBid(new Bid("Mary", 35));
        buyoutAuction.placeBid(new Bid("Mick", 40));

        winner = buyoutAuction.getHighBid();
        System.out.printf("Winning Bid: %s placed a winning bid of %d\n",
                winner.getBidder(), winner.getBidAmount());

        ReserveAuction reserveAuction = new ReserveAuction("GI Joe T-Shirt", 25);
        reserveAuction.placeBid(new Bid("Josh", 1));
        reserveAuction.placeBid(new Bid("Fred", 25));

        // Even though I have different subclasses of Auction, they are all still auctions,
        // much like all the classes that implent the List interface are all Lists
        List<Auction> allAuctions = new ArrayList<>();
        allAuctions.add(generalAuction);
        allAuctions.add(buyoutAuction);
        allAuctions.add(reserveAuction);

        // If I iterate over the list of auctions, I don't know the specific type...
        for(Auction auction : allAuctions){
            // Here I can only call methods from the auction class...
            // When looping over, you want to be doing something common
            // a method from the parent class type

            // What is the current high bid on all auctions?
            auction.getHighBid();


            // Place a low bid on all auctions to try and get stuff cheap...
            auction.placeBid(new Bid("Josh", 1));

            // Yes, you can cast to access subclass stuff,
            // but no one really does this. It is a little risky.
            // This will crash if you cast incorrectly.
            // See 'typeof' for a way to check.
//            BuyoutAuction ba = (BuyoutAuction)auction;
//            ba.buyoutAuctionMethod();
        }

        // Can't see this now because it is no longer in the same package
        //buyoutAuction.protectedMethod();

    }
}
