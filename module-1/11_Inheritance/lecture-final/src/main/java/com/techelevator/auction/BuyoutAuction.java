package com.techelevator.auction;

import com.techelevator.auction.Auction;

public class BuyoutAuction extends Auction {

    // new property for the buyout price
    private int buyoutPrice;

    // DO NOT repeat the properties in your parent class!
    // You already have them and can use them with *this*


    // no modifier means package-private access only visible in the class itself
    // AND others in the same package. DON'T DO IT! Bad practice.
    // Best practice is to ALWAYS add an access modifier.
    // String noModifier;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        // MUST create the parent part first
        super(itemForSale);
        // THEN we can set our own (child) properties.
        this.buyoutPrice = buyoutPrice;

        // Can see protected parts of my parent, but not private
        //this.protectedMethod();
    }

    // You don't *HAVE TO* always have the same Constructor signatures in your
    // child / derived / subclasses... BUT you always MUST call one of your
    // parent class constructors.
//    public BuyoutAuction() {
//        super("Grey Pencil");
//    }


    // No setter, it shouldn't change once the auction is created
    public int getBuyoutPrice() {
        return buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if (getHighBid().getBidAmount() < buyoutPrice) {
            // No one has "won"
            if (offeredBid.getBidAmount() >= buyoutPrice){
                // If the bid amount is greater than the buyout price
                // Update the bid to be the buyout price
                // Really nice of us, huh? Keeping you from paying extra
                offeredBid = new Bid(offeredBid.getBidder(), this.buyoutPrice);
            }
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        // Someone has already won the auction
        return isCurrentWinningBid;
    }

    public void buyoutAuctionMethod(){
        System.out.println("In a buyout auction only method");
    }
}
