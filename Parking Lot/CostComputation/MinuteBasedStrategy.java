package CostComputation;

import enums.VehicleTypes;

public class MinuteBasedStrategy implements CostComputation {

    @Override
    public int CalculateTheCost(VehicleTypes type) {
        return switch(type) {
            case TWO_WHEELER -> 15;
            case THREE_WHEELER -> 30;
            case FOUR_WHEELER -> 45;
        };
    }
    
}
