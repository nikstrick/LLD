package BMS.Entities.Records;

import BMS.Entities.Enums.SeatType;

public record Seat(
        int id,
        SeatType seatType,
        int row
) {
}
