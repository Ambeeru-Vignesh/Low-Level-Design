import java.util.*;

import ParkingSpot.FourWheelerParkingSpot;
import ParkingSpot.ParkingSpot;
import ParkingSpot.ThreeWheelerParkingSpot;
import ParkingSpot.TwoWheelerParkingSpot;
import ParkingSpot.Strategy.DefaultParkingStrategy;
import ParkingSpot.Strategy.ParkingStrategy;
import enums.VehicleTypes;

public class ParkingSpotManager {
    private Map<VehicleTypes,List<ParkingSpot>> parkingSpotsByType;
    private ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkings) {
        this.parkingSpotsByType = new HashMap<>();
        intializeParkingSpots(parkings);
        this.parkingStrategy = new DefaultParkingStrategy(parkings);
    }

    private void intializeParkingSpots(List<ParkingSpot> parkingSpots) {

        for (VehicleTypes type: VehicleTypes.values()){
            parkingSpotsByType.put(type, new ArrayList<>());
        } 

        for(ParkingSpot spot: parkingSpots){

            if(spot instanceof TwoWheelerParkingSpot){
                parkingSpotsByType.get(VehicleTypes.TWO_WHEELER).add(spot);
            } else if (spot instanceof ThreeWheelerParkingSpot){
                parkingSpotsByType.get(VehicleTypes.THREE_WHEELER).add(spot);
            } else{
                parkingSpotsByType.get(VehicleTypes.FOUR_WHEELER).add(spot);
            }

        }
        
    }

    public ParkingSpot findParkingSpot(VehicleTypes vehicleType) {
        List<ParkingSpot> availableSpots = parkingSpotsByType.get(vehicleType);
        if (availableSpots == null || availableSpots.isEmpty()) {
            System.out.println("No parking spots available for vehicle type: " + vehicleType);
            return null;
        }
        
        return availableSpots.stream()
                .filter(spot -> !spot.isOccupied())
                .findFirst()
                .orElse(null);
    }
    
    public void addParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof TwoWheelerParkingSpot) {
            parkingSpotsByType.get(VehicleTypes.TWO_WHEELER).add(parkingSpot);
        } else if (parkingSpot instanceof ThreeWheelerParkingSpot) {
            parkingSpotsByType.get(VehicleTypes.THREE_WHEELER).add(parkingSpot);
        } else if (parkingSpot instanceof FourWheelerParkingSpot) {
            parkingSpotsByType.get(VehicleTypes.FOUR_WHEELER).add(parkingSpot);
        }
    }
    
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof TwoWheelerParkingSpot) {
            parkingSpotsByType.get(VehicleTypes.TWO_WHEELER).remove(parkingSpot);
        } else if (parkingSpot instanceof ThreeWheelerParkingSpot) {
            parkingSpotsByType.get(VehicleTypes.THREE_WHEELER).remove(parkingSpot);
        } else if (parkingSpot instanceof FourWheelerParkingSpot) {
            parkingSpotsByType.get(VehicleTypes.FOUR_WHEELER).remove(parkingSpot);
        }
    }
    
    public void parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findParkingSpot(vehicle.getType());
        if (spot != null) {
            if (spot.occupy(vehicle.getType())) {
                System.out.println("Vehicle parked successfully in " + spot);
            } else {
                System.out.println("Failed to park vehicle in " + spot);
            }
        } else {
            System.out.println("No available parking spots for vehicle type: " + vehicle.getType());
        }
    }
    
    public List<ParkingSpot> getParkingsByType(VehicleTypes type) {
        return new ArrayList<>(parkingSpotsByType.get(type));
    }
    
    public Map<VehicleTypes, List<ParkingSpot>> getAllParkings() {
        Map<VehicleTypes, List<ParkingSpot>> copy = new HashMap<>();
        for (Map.Entry<VehicleTypes, List<ParkingSpot>> entry : parkingSpotsByType.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }
    
}
