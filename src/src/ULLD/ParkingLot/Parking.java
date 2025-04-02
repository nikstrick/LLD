package ULLD.ParkingLot;


public record Parking(
        Integer floor,
        Integer row,
        Integer col,
        Integer type,
        Integer cost,
        Long time,
        Boolean isOccupied
) {
}
