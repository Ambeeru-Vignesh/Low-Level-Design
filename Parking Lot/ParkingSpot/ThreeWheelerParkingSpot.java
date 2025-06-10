package ParkingSpot;

import enums.Floor;
import enums.VehicleTypes;

public class ThreeWheelerParkingSpot extends ParkingSpot {

    public ThreeWheelerParkingSpot(Floor floor) {
        super(false, floor);
        this.price = 30; // Base price for three-wheeler parking
    }

    @Override
    public boolean occupy(VehicleTypes type) {
        if (type == VehicleTypes.THREE_WHEELER && !isOccupied) {
            isOccupied = true;
            return true;
        }
        return false;
    }

    @Override
    public void free_space() {
        isOccupied = false;
    }
}
