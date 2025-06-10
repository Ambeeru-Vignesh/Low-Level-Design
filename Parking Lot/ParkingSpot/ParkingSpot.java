package ParkingSpot;

import enums.Floor;
import enums.VehicleTypes;

public abstract class ParkingSpot {

    protected boolean isOccupied = false;
    protected Floor FloorNum;
    protected int price;

    public ParkingSpot(boolean isOccupied, Floor FloorNum) {
        this.isOccupied = isOccupied;
        this.FloorNum = FloorNum;
        this.price = price;
    }

    public abstract boolean occupy(VehicleTypes type);
    public abstract void free_space();

    public boolean isOccupied() {
        return isOccupied;
    }

    public Floor getFloorNum(){
        return FloorNum;
    }

    public int getPrice() {
        return price;
    }
}