package ULLD.LiftDesign;

import ULLD.LiftDesign.Entities.Direction;
import ULLD.LiftDesign.Entities.Lift;
import ULLD.LiftDesign.Entities.Request;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LiftController {
    private Integer floors;
    private ConcurrentHashMap<Integer, Lift> lifts;

    // Constructor to create Lift system
    public LiftController(Integer floors, Integer liftCount) {
        this.floors = floors;
        this.lifts = new ConcurrentHashMap<>();
        for(int i = 1; i <= liftCount; i++) {
            Lift lift = new Lift(i,1, Direction.UP, 0, new LinkedList<>(), new LinkedList<>());
            lifts.put(i, lift);
        }
    }

    public void makeLiftRequest(Request req) {
        List<Lift> liftInDirection;
        if(req.directionRequest() == Direction.UP) {
            liftInDirection = lifts.values().parallelStream()
                    .filter(it -> it.getLiftDirection() == req.directionRequest() && it.getLiftFloor() < req.floorRequest())
                    .sorted(Comparator.comparingInt(Lift::getLiftFloor).reversed())
                    .toList();
        }else{
            liftInDirection = lifts.values().parallelStream()
                    .filter(it -> it.getLiftDirection() == req.directionRequest() && it.getLiftFloor() > req.floorRequest())
                    .sorted(Comparator.comparingInt(Lift::getLiftFloor))
                    .toList();
        }
        if(liftInDirection.isEmpty()) {
            liftInDirection = lifts.values().parallelStream()
                    .min(Comparator.comparingInt(it -> it.getRequests().size()))
                    .stream().toList();

            assignRequest(req, liftInDirection.get(0), 1);
        } else{
            assignRequest(req, liftInDirection.get(0), 2);
        }
    }

    public void setLiftFloorAndRemoveRequest(Integer floor, Integer liftId) {
        Lift lift = lifts.get(liftId);
        lift.setLiftFloor(floor);
        lift.removeRequestFirst();
    }

    public void makeFloorRequest(Integer floorRequest, Integer liftId) {
        Lift lift = lifts.get(liftId);
        Request recentRequest = lift.getRequests().getFirst();
        Request request = new Request((floorRequest>lift.getLiftFloor())?Direction.UP: Direction.DOWN, floorRequest);
        if(request.directionRequest() == lift.getLiftDirection()) {
            lift.getRequests().addLast(request);
            if(lift.getLiftDirection() == Direction.UP) {
                lift.getRequests().stream().sorted(Comparator.comparing(Request::floorRequest));
            }else{
                lift.getRequests().stream().sorted(Comparator.comparing(Request::floorRequest).reversed());
            }
        }else{
            lift.getCounterRequests().addLast(request);
        }
        if(lift.getRequests().size() == 0) {
            lift.setRequests(lift.getCounterRequests());
            lift.getCounterRequests().clear();
            if(lift.getLiftDirection() == Direction.UP) {
                lift.getRequests().stream().sorted(Comparator.comparing(Request::floorRequest).reversed());
            }else{
                lift.getRequests().stream().sorted(Comparator.comparing(Request::floorRequest));
            }
        }
    }

    public void assignRequest(Request req, Lift lift, Integer strategy) {
        switch (strategy){
            case 1:
                lift.getCounterRequests().addLast(req);
                break;
            default:
                lift.getRequests().addLast(req);
                break;
        }
        switch(req.directionRequest()){
            case UP:
                Collections.sort((LinkedList<Request>) lift.getRequests(), Comparator.comparing(Request::floorRequest));
                break;
            default:
                Collections.sort((LinkedList<Request>) lift.getRequests(), Comparator.comparing(Request::floorRequest).reversed());
                break;
        }
    }

    public void updateLiftFloorState(Integer floor, int id){
        lifts.get(id).setLiftFloor(floor);
    }

    public void getLiftState(Integer id){
        Lift lift = lifts.get(id);

        System.out.println("lift id:"+ lift.getId());
        System.out.println("lift floor:"+ lift.getLiftFloor());
        System.out.println("lift direction:"+ lift.getLiftDirection());
        System.out.println("count people:"+ lift.getCountPeople());
        System.out.println("requests:"+ lift.getRequests());
        System.out.println("Counter requests:"+ lift.getCounterRequests());
        System.out.println("------------------------------");
    }
}
