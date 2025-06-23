import java.util.ArrayList;
import java.util.List;

import enums.Direction;
import StrategyPattern.ElevatorStrategy;

public class Building {
    private List<Floor> floors;
    private List<ElevatorCar> elevators;
    private ElevatorController elevatorController;
    private int numberOfFloors;
    private int numOfElevators;

    public Building(int numberOfFloors, int numOfElevators, ElevatorStrategy elevatorStrategy) {
        this.numberOfFloors = numberOfFloors;
        this.numOfElevators = numOfElevators;
        this.floors = new ArrayList<>();
        this.elevators = new ArrayList<>();

        // Initialize floors
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor(i);
            // Add up button for all floors except top floor
            if (i < numberOfFloors - 1) {
                floor.addExternalButton(new ExternalButton(i, Direction.UP, false));
            }
            // Add down button for all floors except ground floor
            if (i > 0) {
                floor.addExternalButton(new ExternalButton(i, Direction.DOWN, false));
            }
            floors.add(floor);
        }

        // Initialize elevators
        for (int i = 0; i < numOfElevators; i++) {
            elevators.add(new ElevatorCar(i + 1));
        }

        // Initialize controller
        this.elevatorController = new ElevatorController(numOfElevators, numberOfFloors, elevatorStrategy);
    }

    public void requestElevator(int floorNumber, Direction direction) {
        if (floorNumber < 0 || floorNumber >= numberOfFloors) {
            throw new IllegalArgumentException("Invalid floor number");
        }

        floors.get(floorNumber).pressButton(direction);
        elevatorController.requestElevator(floorNumber, direction);
    }

    public void pressInternalButton(int elevatorId, int floorNumber) {
        if (elevatorId < 0 || elevatorId >= numOfElevators) {
            throw new IllegalArgumentException("Invalid elevator ID");
        }
        if (floorNumber < 0 || floorNumber >= numberOfFloors) {
            throw new IllegalArgumentException("Invalid floor number");
        }

        elevators.get(elevatorId).pressButton(floorNumber);
    }

    public void startElevatorSystem() {
        elevatorController.startElevatorSystem();
    }

    public void setStrategy(ElevatorStrategy strategy) {
        elevatorController.setStrategy(strategy);
    }

    // Getters
    public List<Floor> getFloors() { return floors; }
    public List<ElevatorCar> getElevators() { return elevators; }
    public int getNumberOfFloors() { return numberOfFloors; }
    public int getNumberOfElevators() { return numOfElevators; }
}