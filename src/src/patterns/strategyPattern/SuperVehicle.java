package patterns.strategyPattern;

import patterns.strategyPattern.strategy.SportsDrive;

public class SuperVehicle extends Vehicle {
    SuperVehicle(){super(new SportsDrive());}
}
