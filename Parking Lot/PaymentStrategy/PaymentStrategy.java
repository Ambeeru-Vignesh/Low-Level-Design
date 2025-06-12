package PaymentStrategy;

public interface PaymentStrategy {
    boolean processPayment(double amount);
    String getPaymentMethod();
}
