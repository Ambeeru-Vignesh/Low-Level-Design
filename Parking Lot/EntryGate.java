import CostComputation.CostComputation;
import ParkingSpot.ParkingSpot;
import enums.VehicleTypes;

public class EntryGate {

    private Ticket ticket;
    private ParkingSpotManager parkingSpotManager;

    public EntryGate(ParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }

    public Ticket bookAndGiveTicket(VehicleTypes VehicleType, CostComputation costComputation){
        ParkingSpot spot = parkingSpotManager.findParkingSpot(VehicleType);

        if (spot != null && spot.occupy(VehicleType)){
            int cost = costComputation.CalculateTheCost(VehicleType);
            this.ticket = new Ticket(spot.getFloorNum().ordinal(), "1234", VehicleType,cost, spot);

            return ticket;
        }
        return null;  
    }
    
}
