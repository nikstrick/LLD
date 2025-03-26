package patterns.strategyPattern;

import patterns.strategyPattern.strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveObj;

    Vehicle(DriveStrategy driveObj) {
        this.driveObj = driveObj;
    }

    public void drive() {
       driveObj.drive();
    }

}
