package Exercise1.StructuralDP.adapter;

public class GatewayAdapter implements PaymentProcessor {
    private NewPaymentGateway newGateway;

    public GatewayAdapter(NewPaymentGateway newGateway) {
        this.newGateway = newGateway;
    }

    @Override
    public void processPayment(double amount) {
        
        newGateway.makePayment(amount);
    }
}