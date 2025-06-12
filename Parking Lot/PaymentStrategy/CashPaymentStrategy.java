package PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing cash payment of amount: " + amount);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "CASH";
    }
}
