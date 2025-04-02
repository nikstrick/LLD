package ULLD.LiftDesign.Entities;

import java.util.Deque;
import java.util.LinkedList;

public class Lift {
    private Integer id;
    private Integer liftFloor;
    private Direction liftDirection;
    private Integer countPeople;
    private Deque<Request> requests;
    private Deque<Request> counterRequests;

    public Lift(
            Integer id,
            Integer liftFloor,
            Direction liftDirection,
            Integer countPeople,
            Deque<Request> requests,
            Deque<Request> counterRequests
    ) {
        this.id = id;
        this.liftFloor = liftFloor;
        this.liftDirection = liftDirection;
        this.countPeople = countPeople;
        this.requests = new LinkedList<>();
        this.counterRequests = new LinkedList<>();
    }

    public Integer getId() {
        return id;
    }
    public Integer getLiftFloor() {
        return liftFloor;
    }
    public Direction getLiftDirection() {
        return liftDirection;
    }
    public Integer getCountPeople() {
        return countPeople;
    }
    public Deque<Request> getRequests() {
        return requests;
    }

    public void removeRequestFirst() {
        this.requests.removeFirst();
    }

    public void setLiftDirection(Direction liftDirection) {
        this.liftDirection = liftDirection;
    }

    public void setLiftFloor(Integer liftFloor) {
        this.liftFloor = liftFloor;
    }

    public Deque<Request> getCounterRequests() {
        return counterRequests;
    }
    public void setCounterRequests(Deque<Request> counterRequests) {
        this.counterRequests = counterRequests;
    }
    public void setRequests(Deque<Request> requests) {
        this.requests = requests;
    }
}
