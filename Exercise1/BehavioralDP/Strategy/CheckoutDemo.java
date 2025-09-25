package Exercise1.BehavioralDP.Strategy;

public class CheckoutDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        double packageWeight = 5.5; // 5.5 kg

        // User selects Standard Shipping
        cart.setShippingStrategy(new StandardShipping());
        double standardCost = cart.calculateShippingCost(packageWeight);
        System.out.printf("Standard Shipping Cost for %.1fkg: $%.2f%n", packageWeight, standardCost);

        // User switches to Express Shipping
        cart.setShippingStrategy(new ExpressShipping());
        double expressCost = cart.calculateShippingCost(packageWeight);
        System.out.printf("Express Shipping Cost for %.1fkg: $%.2f%n", packageWeight, expressCost);
    }
}