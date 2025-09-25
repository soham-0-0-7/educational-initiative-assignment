package Exercise1.StructuralDP.adapter;

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor processor;

        NewPaymentGateway newGateway = new NewPaymentGateway();

        processor = new GatewayAdapter(newGateway);

        processor.processPayment(199.99);
    }
}