package BMS.Entities.Records;

import java.util.List;

public record Screen(
        int id,
        List<Seat> seats
) {
}
