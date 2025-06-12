package ParkingSpot;

import enums.Floor;
import enums.VehicleTypes;

public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(Floor floor) {
        super(false, floor);
        this.price = 20; // Base price for two-wheeler parking
    }

    @Override
    public boolean occupy(VehicleTypes type) {
        if (type == VehicleTypes.TWO_WHEELER && !isOccupied) {
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
