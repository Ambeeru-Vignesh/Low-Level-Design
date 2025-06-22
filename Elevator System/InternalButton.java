public class InternalButton {
    private int floor;
    private boolean isPressed;

    public InternalButton(int floor_num) {
        this.floor = floor_num;
        this.isPressed = false;
    }

    public void pressButton(){
        this.isPressed = true;
    }

    public void resetButton(){
        this.isPressed = false;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public int getFloor() {
        return floor;
    }
}