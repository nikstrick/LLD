package ULLD.ParkingLot;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public interface ParkingStrategy {
    public Optional<Parking> getParking(ConcurrentHashMap<Integer, Parking> parkings);
}
