import java.util.ArrayList;
import java.util.List;

import enums.Direction;

public class Floor {

    private int floorNum;
    private List<ExternalButton> buttons;

    public Floor(int floorNumber){
        this.floorNum = floorNumber;
        this.buttons = new ArrayList<>();
    }

    public void addExternalButton(ExternalButton button){
        buttons.add(button);
    }

    public void pressButton(Direction direction){
        for(ExternalButton button: buttons){
            if (button.getDirection() == direction) {
                button.pressButton();
            }
        }
    }
    
    public void resetButton(Direction direction) {
        for(ExternalButton button: buttons) {
            if(button.getDirection() == direction) {
                button.resetButton();
            }
        }
    }

    // Getters
    public int getFloorNumber() { return floorNum; }
    public List<ExternalButton> getButtons() { return buttons; }
}