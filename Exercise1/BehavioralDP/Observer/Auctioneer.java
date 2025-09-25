
package Exercise1.BehavioralDP.Observer;

public interface Auctioneer {
    void registerObserver(Bidder bidder);
    void removeObserver(Bidder bidder);
    void notifyObservers();
}