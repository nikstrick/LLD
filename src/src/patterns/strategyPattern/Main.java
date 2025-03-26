package patterns.strategyPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Vehicle tataTruck = new PassengerVehicle();
        Vehicle bmwSport = new SuperVehicle();
        Vehicle defender = new SuperVehicle();

        defender.drive();
        tataTruck.drive();
        bmwSport.drive();

    }
}
