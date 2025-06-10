package CostComputation;

import enums.VehicleTypes;

public class HourBasedStrategy implements CostComputation{

    @Override
    public int CalculateTheCost(VehicleTypes type) {
        
        int baseRate = switch (type) {
            case TWO_WHEELER -> 2;
            case THREE_WHEELER -> 3;
            case FOUR_WHEELER -> 5;
                
        };
        
        return baseRate*60;

    }
    
}
