package Exercise1.BehavioralDP.Observer;

public class RegisteredBidder implements Bidder {
    private String name;

    public RegisteredBidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String bidderName, double currentBid) {
        if (!this.name.equals(bidderName)) {
            System.out.println("Hello " + this.name + "! A new bid of $" + currentBid + " was placed by " + bidderName);
        }
    }
}