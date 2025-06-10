package ParkingSpot.Strategy;
import java.util.List;
import ParkingSpot.ParkingSpot;

public class NearToEntranceParkingStrategy implements ParkingStrategy {

    private List<ParkingSpot> parkingSpots;

    public NearToEntranceParkingStrategy(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    @Override
    public ParkingSpot findingParkSlot() {
        
        return parkingSpots.stream()
        .filter(spot - > !spot.isOccupied() && spot.getFloorNum() == 1) // Assuming entrance is on floor 1
        .findFirst()

    }
    
}
