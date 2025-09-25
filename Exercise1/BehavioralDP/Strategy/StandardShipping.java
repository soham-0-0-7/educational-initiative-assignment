package Exercise1.BehavioralDP.Strategy;


public class StandardShipping implements ShippingStrategy {
    @Override
    public double calculate(double weightInKg) {
        return weightInKg * 2.50; // $2.50 per kg
    }
}