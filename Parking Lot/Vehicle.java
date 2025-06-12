import enums.VehicleTypes;

public class Vehicle {
    private String vehicleNumber;
    private String color;
    private VehicleTypes type;

    public Vehicle(VehicleTypes type, String color, String vehicleNumber) {
        this.type = type;
        this.color = color;
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleTypes getType() {
        return type;
    }

    public String getColor() {
        return color;
    }
}
