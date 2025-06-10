import ParkingSpot.ParkingSpot;
import enums.VehicleTypes;

public class Ticket {
    private int floorNo;
    private String TicketId;
    private VehicleTypes vehicleType;
    private int cost;
    private ParkingSpot parkingSpot;
    private int entryTime;

    public Ticket(int floorNo, String ticketId, VehicleTypes vehicleType, int cost, ParkingSpot parkingSpot) {
        this.floorNo = floorNo;
        TicketId = ticketId;
        this.vehicleType = vehicleType;
        this.cost = cost;
        this.parkingSpot = parkingSpot;
        this.entryTime = (int) (System.currentTimeMillis() / 1000); // Current time in seconds
    }

    public int getFloorNo() {
        return floorNo;
    }
    public String getTicketId() {
        return TicketId;
    }
    public VehicleTypes getVehicleType() {
        return vehicleType;
    }
    public int getCost() {
        return cost;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    public int getEntryTime() {
        return entryTime;
    }
    
}
