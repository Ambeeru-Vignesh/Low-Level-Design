import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import enums.Direction;
import enums.Door;
import enums.Status;

public class ElevatorCar {
    private int id;
    private int currentFloor;
    private ElevatorDisplay elevatorDisplay;

    private Direction direction;
    private Status status;
    private Door door;
    
    private Queue<Integer> destinations;
    private Map<Integer, Internal_Button> internalButtons;

    public ElevatorCar(int id) {
        this.currentFloor = 0;
        this.elevatorDisplay = new ElevatorDisplay();
        this.direction = Direction.IDLE;
        this.status = Status.IDLE;
        this.door = Door.CLOSED;

        destinations = new LinkedList<>();
        internalButtons = new HashMap<>();
    }

    public void move() {
        if (destinations.isEmpty()){
            status = Status.IDLE;
            direction = Direction.IDLE;
            return;
        }

        int nextFloor = destinations.peek();
        if(nextFloor > currentFloor){
            direction = Direction.UP;
            currentFloor++;
        } else if (nextFloor < currentFloor){
            direction = Direction.DOWN;
            currentFloor--;
        }

        if(currentFloor == nextFloor){
            destinations.poll();
            openDoor();

            if (internalButtons.containsKey(currentFloor)){
                internalButtons.get(currentFloor).resetButton();
            }

            closeDoor();
        }
    }

    public void pressButton(int floor_num){
        if(!internalButtons.containsKey(floor_num)){
            internalButtons.put(floor_num, new Internal_Button(floor_num));
        }
        internalButtons.get(floor_num).pressButton();
        destinations.add(floor_num);
    }

    public void openDoor() {
        door = Door.OPEN;
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void closeDoor() {
        door = Door.CLOSED;
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    

}
