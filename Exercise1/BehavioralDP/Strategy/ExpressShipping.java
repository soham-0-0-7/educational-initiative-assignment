package Exercise1.BehavioralDP.Strategy;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculate(double weightInKg) {
        return weightInKg * 4.75; // $4.75 per kg
    }
}