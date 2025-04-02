package ULLD.ParkingLot;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class ParkingStrategy1 implements ParkingStrategy {
    @Override
    public Optional<Parking> getParking(ConcurrentHashMap<Integer, Parking> parkings) {

        return parkings.values().stream()
                .filter(entry -> !entry.isOccupied())
                .findFirst();
    }
}
