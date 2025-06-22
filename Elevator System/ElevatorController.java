import java.util.ArrayList;
import java.util.List;

import enums.Direction;

public class ElevatorController {
    private List<ElevatorCar> elevators;
    private ElevatorStrategy strategy;
    private int numberOfFloors;

    public ElevatorController(int numOfElevators, int numberOfFloors, ElevatorStrategy strategy){
        this.elevators = new ArrayList<>();
        this.strategy = strategy;
        this.numberOfFloors = numberOfFloors;
        for (int i = 0; i < numOfElevators; i++){
            elevators.add(new ElevatorCar(i + 1));
        }
    }

    public void requestElevator(int floor, Direction direction){
        if (floor < 0 || floor >= numberOfFloors) {
            throw new IllegalArgumentException("Invalid floor number");
        }

        ElevatorCar selectedElevatorCar = strategy.selectElevator(elevators, floor, direction);
        if (selectedElevatorCar != null){
            selectedElevatorCar.addDestination(floor);
        } else {
            System.out.println("No elevator available at the moment");
        }
    
    }

    public void setStrategy(ElevatorStrategy strategy){
        this.strategy = strategy;
    }

    public void startElevatorSystem(){
        for (ElevatorCar elevator: elevators){
            new Thread(() -> {
                while (true) {
                    elevator.move();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}