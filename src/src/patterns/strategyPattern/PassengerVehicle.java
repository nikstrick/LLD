package patterns.strategyPattern;

import patterns.strategyPattern.strategy.NormalDrive;

public class PassengerVehicle extends Vehicle {
    PassengerVehicle(){
        super(new NormalDrive());
    }
}
