package CostComputation;

import enums.VehicleTypes;

public class DefaultStrategy implements CostComputation {

    @Override
    public int CalculateTheCost(VehicleTypes type) {
        // TODO Auto-generated method stub
        switch (type) {
            case TWO_WHEELER:
                return 10;
            case THREE_WHEELER:
                return 20;
            case FOUR_WHEELER:
                return 30;
            default:
                return 0;
        }
    }
    
}
