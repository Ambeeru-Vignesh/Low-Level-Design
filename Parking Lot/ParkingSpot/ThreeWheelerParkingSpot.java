package ParkingSpot;

import enums.Floor;
import enums.VehicleTypes;

public class ThreeWheelerParkingSpot extends ParkingSpot {

    public ThreeWheelerParkingSpot(boolean isOccupied, Floor FloorNum) {
        super(isOccupied, FloorNum);
    }

    @Override
    public boolean occupy(VehicleTypes type) {
         if (type == VehicleTypes.TWO_WHEELER && !isOccupied){
            isOccupied = true;
            return true;
        }

        return false;
    }

    @Override
    public void free_space() {
        // TODO Auto-generated method stub
         isOccupied = false;
    }
    
}
