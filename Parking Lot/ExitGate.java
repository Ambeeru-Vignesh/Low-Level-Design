import CostComputation.CostComputation;
import ParkingSpot.ParkingSpot;
import PaymentStrategy.PaymentStrategy;

public class ExitGate {
    private Ticket ticket;
    private PaymentStrategy paymentStrategy;
    private ParkingSpot parkingSpot;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public boolean payPrice() {
        int price = ticket.getCost();
        if(paymentStrategy.processPayment(price)){
            return true;
        }
        return false;
    }

    public boolean vacateParkingSpot(){
        if (parkingSpot != null){
            parkingSpot.free_space();
            return true;
        }
        return false;
    }

    public void processExit(Ticket ticket, CostComputation costComputation){
        if (payPrice() && vacateParkingSpot()){
            System.out.println("Process Successfull");
        }
        else {
            System.out.println("Process Failed");
        }
    }  
}
