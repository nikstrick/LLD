package patterns.strategyPattern.strategy;

public class SportsDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("It's a SportsDrive vehicle!");
    }
}
