package com.techelevator.auction;

import com.techelevator.auction.Auction;

public class BuyoutAuction extends Auction {

    //new property for the buyout price
    private int buyoutPrice;

    // DO NOT repeat properties from the parent class!
    // You already have them and can use them with *this*


    // MUST ALWAYS call one of the parents constructors
    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        //MUST create the parent part first
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }


    // No setter, it shouldn't change once auction is created
    public int getBuyoutPrice() {
        return buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if (getHighBid().getBidAmount() < buyoutPrice) {
            //No one has "won" yet
        if (offeredBid.getBidAmount() >= buyoutPrice) {
            //If the bid amount is greater than the buyout price
            //Update the bid to be the buyout price
            offeredBid = new Bid(offeredBid.getBidder(), this.buyoutPrice);
        }

        isCurrentWinningBid = super.placeBid(offeredBid);
        }
        // Someone has already "won"
        return isCurrentWinningBid;
    }

}
