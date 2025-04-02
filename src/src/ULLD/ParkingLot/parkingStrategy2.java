package ULLD.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class parkingStrategy2 implements ParkingStrategy {
    @Override
    public Optional<Parking> getParking(ConcurrentHashMap<Integer, Parking> parkings) {

//        Optional<Map.Entry<Integer, Parking>> findSpot = parkings.entrySet().stream()
//                .filter(entry -> !entry.getValue().isOccupied())
//                .findFirst();
        return Optional.empty();

    }
}
