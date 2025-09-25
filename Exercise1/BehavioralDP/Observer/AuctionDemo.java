
package Exercise1.BehavioralDP.Observer;

public class AuctionDemo {
    public static void main(String[] args) {
        LiveAuctioneer auctioneer = new LiveAuctioneer();

        Bidder bidder1 = new RegisteredBidder("Alice");
        Bidder bidder2 = new RegisteredBidder("Bob");
        Bidder bidder3 = new RegisteredBidder("Charlie");

        auctioneer.registerObserver(bidder1);
        auctioneer.registerObserver(bidder2);
        auctioneer.registerObserver(bidder3);

        auctioneer.placeBid("Alice", 100.00);
        auctioneer.placeBid("Bob", 125.50);
        auctioneer.removeObserver(bidder3);
        auctioneer.placeBid("Alice", 150.75);
    }
}