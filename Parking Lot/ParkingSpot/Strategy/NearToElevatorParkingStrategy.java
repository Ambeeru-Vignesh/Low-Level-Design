package ParkingSpot.Strategy;
import java.util.List;
import ParkingSpot.ParkingSpot;
import enums.Floor;

public class NearToElevatorParkingStrategy implements ParkingStrategy {

    private List<ParkingSpot> parkingSpots;

    public NearToElevatorParkingStrategy(List<ParkingSpot> parkingSpots){
        this.parkingSpots = parkingSpots;
    }

    @Override
    public ParkingSpot findingParkSlot() {
        // TODO Auto-generated method stub
        return parkingSpots.stream()
        .filter(spot -> !spot.isOccupied() && (spot.getFloorNum() == Floor.SECOND || 
                         spot.getFloorNum() == Floor.THIRD))
        .findFirst()
        .orElse(null);
    }
    
}