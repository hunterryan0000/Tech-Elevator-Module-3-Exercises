package com.techelevator.auction;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;

	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		// Set up a default high bid so the comparison in the placeBid works for the 1st bid
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
	}

	public boolean placeBid(Bid offeredBid) {
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;
		if (offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		return isCurrentWinningBid;
	}

	public Bid getHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}

	// The protected modifier allows something to be seen by child classes
	// AND other classes in the same package, BUT not the general public
//	protected void protectedMethod() {
//		System.out.println("This is a protected method");
//	}
}
