
package Exercise1.BehavioralDP.Observer;

import java.util.ArrayList;
import java.util.List;

public class LiveAuctioneer implements Auctioneer {
    private List<Bidder> bidders = new ArrayList<>();
    private double currentBid;
    private String highestBidderName;

    public void placeBid(String bidderName, double amount) {
        if (amount > currentBid) {
            System.out.println("\nNew highest bid of $" + amount + " placed by " + bidderName);
            this.currentBid = amount;
            this.highestBidderName = bidderName;
            notifyObservers();
        }
    }

    @Override
    public void registerObserver(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void removeObserver(Bidder bidder) {
        bidders.remove(bidder);
    }

    @Override
    public void notifyObservers() {
        for (Bidder bidder : bidders) {
            bidder.update(highestBidderName, currentBid);
        }
    }
}