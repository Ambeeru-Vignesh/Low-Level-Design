import enums.Direction;

public class ElevatorDisplay {
    private int floor_num;
    private Direction direction;

    public void setDisplay(int floor_num, Direction direction) {
        this.floor_num = floor_num;
        this.direction = direction;
    }

    public void showDisplay(){
        System.out.println(floor_num);
        System.out.println(direction);
    }
}
