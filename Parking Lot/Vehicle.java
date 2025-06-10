import enums.VehicleTypes;

public class Vehicle {
    private String vehicle_num;
    private VehicleTypes type;

    public Vehicle(String vehicle_num, VehicleTypes type){
        this.vehicle_num = vehicle_num;
        this.type = type;
    }

    public String getVehicleNumber(){
        return vehicle_num;
    }

    public VehicleTypes getType(){
        return type;
    }
}
