package ULLD.LiftDesign;

import ULLD.LiftDesign.Entities.Direction;
import ULLD.LiftDesign.Entities.Request;


public class Main {
    private static LiftController liftController;
    public static void main(String[] args) {
        liftController = new LiftController(10, 2);

        liftController.getLiftState(1);
        liftController.getLiftState(2);


        liftController.makeLiftRequest(new Request(Direction.UP, 8));
        liftController.updateLiftFloorState(5,1);
        liftController.makeLiftRequest(new Request(Direction.UP, 7));
        liftController.makeLiftRequest(new Request(Direction.DOWN, 8));
        liftController.setLiftFloorAndRemoveRequest(7,1);

        liftController.getLiftState(1);
        liftController.getLiftState(2);

        liftController.makeFloorRequest(3,1);

        liftController.getLiftState(1);
        liftController.getLiftState(2);
    }
}
