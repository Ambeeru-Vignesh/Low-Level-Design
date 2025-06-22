import java.util.List;
import enums.Direction;

public interface ElevatorStrategy {
    ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction);
} 
