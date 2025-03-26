package patterns.strategyPattern;

import patterns.strategyPattern.strategy.SportsDrive;

public class OffroaderVehicle extends Vehicle {
    OffroaderVehicle(){
        super(new SportsDrive());
    }
}
