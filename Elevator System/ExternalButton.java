import enums.Direction;

public class ExternalButton {
    private int floor_num;
    private Direction direction;
    private Boolean isPressed;

    public ExternalButton(int floor,Direction direction, boolean isPressed){
        this.floor_num = floor;
        this.direction = direction;
        this.isPressed = isPressed;
    }

    public void pressButton() {
        this.isPressed = true;
    }

    public void resetButton() {
        this.isPressed = false;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public int getFloorNumber() {
        return floor_num;
    }

    public Direction getDirection() {
        return direction;
    }
}
