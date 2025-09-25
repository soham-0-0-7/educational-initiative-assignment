package Exercise1.BehavioralDP.Strategy;

public class ShoppingCart {
    private ShippingStrategy shippingStrategy;

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateShippingCost(double weight) {
        if (shippingStrategy == null) {
            throw new IllegalStateException("Shipping strategy not set.");
        }
        return shippingStrategy.calculate(weight);
    }
}