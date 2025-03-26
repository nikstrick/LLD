package patterns.strategyPattern.strategy;

public class NormalDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("It's a Normal drive!");
    }
}
