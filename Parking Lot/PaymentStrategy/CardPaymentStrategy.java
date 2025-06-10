package PaymentStrategy;

public class CardPaymentStrategy implements PaymentStrategy {
    private String CardNumber;
    private String CardName;

    public CardPaymentStrategy(String CardNumber, String CardName) {
        this.CardNumber = CardNumber;
        this.CardName = CardName;
    }

    @Override
    public boolean processPayment(double amount) {
       System.out.println(amount);
       System.out.println(CardName);
       System.out.println(maskCardNumber(CardNumber));
       return true;
    }

    @Override
    public String getPaymentMethod() {
        return "CARD";
    }

    private String maskCardNumber(String CardNumber){
        if (CardNumber == null || CardNumber.length() < 4){
            return CardNumber;
        }
        return "*******";
    }
    
}
