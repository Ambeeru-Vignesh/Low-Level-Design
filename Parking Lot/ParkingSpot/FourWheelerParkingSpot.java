package ParkingSpot;

import enums.Floor;
import enums.VehicleTypes;

public class FourWheelerParkingSpot extends ParkingSpot {

    public FourWheelerParkingSpot(Floor floor) {
        super(false, floor);
        this.price = 50; // Base price for four-wheeler parking
    }

    @Override
    public boolean occupy(VehicleTypes type) {
        if (type == VehicleTypes.FOUR_WHEELER && !isOccupied) {
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
