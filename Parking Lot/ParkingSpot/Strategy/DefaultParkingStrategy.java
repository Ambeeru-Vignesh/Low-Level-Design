package ParkingSpot.Strategy;

import java.util.List;

import ParkingSpot.ParkingSpot;

public class DefaultParkingStrategy implements ParkingStrategy {

    private List<ParkingSpot> parkingSpots;

    public DefaultParkingStrategy(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    @Override
    public ParkingSpot findingParkSlot() {
        return parkingSpots.stream()
                .filter(spot -> !spot.isOccupied())
                .findFirst()
                .orElse(null);
    }
    
}
