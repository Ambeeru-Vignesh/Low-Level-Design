import java.util.ArrayList;
import java.util.List;

import CostComputation.CostComputation;
import CostComputation.DefaultStrategy;
import CostComputation.HourBasedStrategy;
import ParkingSpot.FourWheelerParkingSpot;
import ParkingSpot.ParkingSpot;
import ParkingSpot.ThreeWheelerParkingSpot;
import ParkingSpot.TwoWheelerParkingSpot;
import ParkingSpot.Strategy.NearToEntranceParkingStrategy;
import PaymentStrategy.CardPaymentStrategy;
import PaymentStrategy.CashPaymentStrategy;
import enums.Floor;
import enums.VehicleTypes;

public class ParkingLot {

    public static void main(String[] args) {
        
        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new TwoWheelerParkingSpot(Floor.GROUND));
        spots.add(new ThreeWheelerParkingSpot(Floor.GROUND));
        spots.add(new FourWheelerParkingSpot(Floor.FIRST));
        spots.add(new TwoWheelerParkingSpot(Floor.SECOND));
        
        // Create parking manager
        ParkingSpotManager manager = new ParkingSpotManager(spots);
        
        // Create entrance
        EntryGate entrance = new EntryGate(manager);
        
        // Create vehicles
        Vehicle car = new Vehicle(VehicleTypes.FOUR_WHEELER, "Red", "ABC123");
        Vehicle bike = new Vehicle(VehicleTypes.TWO_WHEELER, "Blue", "XYZ789");
        
        // Park vehicles and get tickets
        CostComputation defaultCost = new DefaultStrategy();
        Ticket carTicket = entrance.bookAndGiveTicket(VehicleTypes.FOUR_WHEELER, defaultCost);
        Ticket bikeTicket = entrance.bookAndGiveTicket(VehicleTypes.TWO_WHEELER, defaultCost);
        
        if (carTicket != null) {
            System.out.println("Car parked. Ticket ID: " + carTicket.getTicketId() + 
                             ", Cost: " + carTicket.getCost());
        }
        
        if (bikeTicket != null) {
            System.out.println("Bike parked. Ticket ID: " + bikeTicket.getTicketId() + 
                             ", Cost: " + bikeTicket.getCost());
        }
        
        // Process exit with different payment methods
        ExitGate exitGate = new ExitGate();
        
        // Test cash payment
        if (carTicket != null) {
            System.out.println("\nTesting Cash Payment:");
            exitGate.setPaymentStrategy(new CashPaymentStrategy());
            exitGate.processExit(carTicket, defaultCost);
        }
        
        // Test card payment
        if (bikeTicket != null) {
            System.out.println("\nTesting Card Payment:");
            exitGate.setPaymentStrategy(new CardPaymentStrategy("4111-1111-1111-1111", "John Doe"));
            exitGate.processExit(bikeTicket, defaultCost);
        }
        
        // Test different parking strategies
        System.out.println("\nUsing Near to Entrance Strategy:");
        manager.setParkingStrategy(new NearToEntranceParkingStrategy(spots));
        
        Vehicle auto = new Vehicle(VehicleTypes.THREE_WHEELER, "Yellow", "DEF456");
        CostComputation hourBasedCost = new HourBasedStrategy();
        Ticket autoTicket = entrance.bookAndGiveTicket(VehicleTypes.THREE_WHEELER, hourBasedCost);
        
        if (autoTicket != null) {
            System.out.println("Auto parked. Ticket ID: " + autoTicket.getTicketId() + 
                             ", Cost: " + autoTicket.getCost());
            
            // Test cash payment for auto
            System.out.println("\nTesting Cash Payment for Auto:");
            exitGate.setPaymentStrategy(new CashPaymentStrategy());
            exitGate.processExit(autoTicket, hourBasedCost);
        }
    }
}
